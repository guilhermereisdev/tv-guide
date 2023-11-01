package com.guilhermereisdev.tvguide.data.repository.movie

import com.guilhermereisdev.tvguide.data.model.movie.Movie
import com.guilhermereisdev.tvguide.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {
    private val movies = mutableListOf<Movie>()

    init {
        movies.add(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 1, originalLanguage = null, originalTitle = null, overview = "overview1", popularity = null, posterPath = "posterPath1", releaseDate = "releaseDate1", title = "title1", video = null, voteAverage = null, voteCount = null)
        )
        movies.add(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 2, originalLanguage = null, originalTitle = null, overview = "overview2", popularity = null, posterPath = "posterPath2", releaseDate = "releaseDate2", title = "title2", video = null, voteAverage = null, voteCount = null)
        )
    }
    override suspend fun getMovies(language: String): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(language: String): List<Movie>? {
        movies.clear()
        movies.add(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 3, originalLanguage = null, originalTitle = null, overview = "overview3", popularity = null, posterPath = "posterPath3", releaseDate = "releaseDate3", title = "title3", video = null, voteAverage = null, voteCount = null)
        )
        movies.add(
            Movie(adult = null, backdropPath = null, genreIds = listOf(27, 9648), id = 4, originalLanguage = null, originalTitle = null, overview = "overview4", popularity = null, posterPath = "posterPath4", releaseDate = "releaseDate4", title = "title4", video = null, voteAverage = null, voteCount = null)
        )
        return movies
    }
}
