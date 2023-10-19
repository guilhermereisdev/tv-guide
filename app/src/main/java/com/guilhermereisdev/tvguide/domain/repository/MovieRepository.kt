package com.guilhermereisdev.tvguide.domain.repository

import com.guilhermereisdev.tvguide.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(language: String): List<Movie>?
    suspend fun updateMovies(language: String): List<Movie>?
}
