package com.guilhermereisdev.tvguide.data.repository.movie.datasourceimpl

import com.guilhermereisdev.tvguide.data.api.TMDBService
import com.guilhermereisdev.tvguide.data.model.movie.MovieList
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
    private val language: String = "pt-BR"
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey, language)
}
