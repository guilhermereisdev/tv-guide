package com.guilhermereisdev.tvguide.presentation.di.movie

import com.guilhermereisdev.tvguide.domain.usecase.GetMoviesUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateMoviesUseCase
import com.guilhermereisdev.tvguide.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase,
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase,
        )
    }
}
