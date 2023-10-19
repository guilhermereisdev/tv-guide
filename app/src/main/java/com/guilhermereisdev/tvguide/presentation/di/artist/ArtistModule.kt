package com.guilhermereisdev.tvguide.presentation.di.artist

import com.guilhermereisdev.tvguide.domain.usecase.GetArtistsUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateArtistsUseCase
import com.guilhermereisdev.tvguide.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase,
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase,
        )
    }
}
