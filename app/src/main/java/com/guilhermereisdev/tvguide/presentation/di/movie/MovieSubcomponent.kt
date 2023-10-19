package com.guilhermereisdev.tvguide.presentation.di.movie

import com.guilhermereisdev.tvguide.presentation.artist.ArtistActivity
import com.guilhermereisdev.tvguide.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubcomponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubcomponent
    }
}
