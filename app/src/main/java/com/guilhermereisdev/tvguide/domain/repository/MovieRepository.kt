package com.guilhermereisdev.tvguide.domain.repository

import com.guilhermereisdev.tvguide.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}
