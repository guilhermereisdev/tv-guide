package com.guilhermereisdev.tvguide.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.guilhermereisdev.tvguide.domain.usecase.GetTVShowsUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateTVShowsUseCase

class TVShowViewModel(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase,
) : ViewModel() {
    fun getTVShows() = liveData {
        val tvShowsList = getTVShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTVShows() = liveData {
        val tvShowsList = updateTVShowsUseCase.execute()
        emit(tvShowsList)
    }
}
