package com.guilhermereisdev.tvguide.presentation.di.artist

import com.guilhermereisdev.tvguide.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubcomponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubcomponent
    }
}
