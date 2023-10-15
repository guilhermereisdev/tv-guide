package com.guilhermereisdev.tvguide.data.repository.movie.datasource

import com.guilhermereisdev.tvguide.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}
