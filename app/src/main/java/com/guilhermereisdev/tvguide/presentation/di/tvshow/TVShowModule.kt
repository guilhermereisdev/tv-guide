package com.guilhermereisdev.tvguide.presentation.di.tvshow

import com.guilhermereisdev.tvguide.domain.usecase.GetTVShowsUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateTVShowsUseCase
import com.guilhermereisdev.tvguide.presentation.tvshow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {
    @TVShowScope
    @Provides
    fun provideTVShowViewModelFactory(
        getTVShowsUseCase: GetTVShowsUseCase,
        updateTVShowsUseCase: UpdateTVShowsUseCase,
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(
            getTVShowsUseCase,
            updateTVShowsUseCase,
        )
    }
}
