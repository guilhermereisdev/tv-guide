package com.guilhermereisdev.tvguide.data.repository.movie.datasource

import com.guilhermereisdev.tvguide.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}
