package com.guilhermereisdev.tvguide.domain.usecase

import com.guilhermereisdev.tvguide.data.model.movie.Movie
import com.guilhermereisdev.tvguide.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}
