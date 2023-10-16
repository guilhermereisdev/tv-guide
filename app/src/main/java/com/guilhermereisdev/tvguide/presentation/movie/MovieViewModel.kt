package com.guilhermereisdev.tvguide.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.guilhermereisdev.tvguide.domain.usecase.GetMoviesUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase,
) : ViewModel() {
    fun getMovies() = liveData {
        val moviesList = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val moviesList = updateMoviesUseCase.execute()
        emit(moviesList)
    }
}
