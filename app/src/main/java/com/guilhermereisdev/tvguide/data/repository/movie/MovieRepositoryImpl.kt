package com.guilhermereisdev.tvguide.data.repository.movie

import android.util.Log
import com.guilhermereisdev.tvguide.data.model.movie.Movie
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieCacheDataSource
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieLocalDataSource
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieRemoteDataSource
import com.guilhermereisdev.tvguide.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
) : MovieRepository {
    override suspend fun getMovies(language: String): List<Movie>? {
        return getMoviesFromCache(language)
    }

    override suspend fun updateMovies(language: String): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI(language)
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(language: String): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies(language)
            val body = response.body()

            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return movieList
    }

    private suspend fun getMoviesFromDB(language: String): List<Movie> {
        var movieList: List<Movie> = emptyList()

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI(language)
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(language: String): List<Movie>? {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB(language)
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}
