package com.guilhermereisdev.tvguide.data.repository.movie.datasourceimpl

import com.guilhermereisdev.tvguide.data.api.TMDBService
import com.guilhermereisdev.tvguide.data.model.movie.MovieList
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService
) : MovieRemoteDataSource {
    override suspend fun getMovies(language: String): Response<MovieList> =
        tmdbService.getPopularMovies(language)
}
