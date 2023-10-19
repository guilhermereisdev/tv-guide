package com.guilhermereisdev.tvguide.data.repository.movie.datasource

import com.guilhermereisdev.tvguide.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(language: String): Response<MovieList>
}
