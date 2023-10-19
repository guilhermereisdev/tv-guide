package com.guilhermereisdev.tvguide.presentation.di.core

import com.guilhermereisdev.tvguide.domain.repository.ArtistRepository
import com.guilhermereisdev.tvguide.domain.repository.MovieRepository
import com.guilhermereisdev.tvguide.domain.repository.TVShowRepository
import com.guilhermereisdev.tvguide.domain.usecase.GetArtistsUseCase
import com.guilhermereisdev.tvguide.domain.usecase.GetMoviesUseCase
import com.guilhermereisdev.tvguide.domain.usecase.GetTVShowsUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateArtistsUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateMoviesUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateTVShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTVShowsUseCase(tvShowRepository: TVShowRepository): GetTVShowsUseCase {
        return GetTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTVShowsUseCase(tvShowRepository: TVShowRepository): UpdateTVShowsUseCase {
        return UpdateTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistsRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistsRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistsRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistsRepository)
    }
}
