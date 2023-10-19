package com.guilhermereisdev.tvguide.domain.usecase

import com.guilhermereisdev.tvguide.data.model.movie.Movie
import com.guilhermereisdev.tvguide.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(language: String): List<Movie>? = movieRepository.updateMovies(language)
}
