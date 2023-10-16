package com.guilhermereisdev.tvguide.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guilhermereisdev.tvguide.domain.usecase.GetTVShowsUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateTVShowsUseCase

class TVShowViewModelFactory(
    private val getTVShowsUseCase: GetTVShowsUseCase,
    private val updateTVShowsUseCase: UpdateTVShowsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(
            getTVShowsUseCase,
            updateTVShowsUseCase,
        ) as T
    }
}
