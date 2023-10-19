package com.guilhermereisdev.tvguide.presentation.di.core

import android.content.Context
import com.guilhermereisdev.tvguide.presentation.di.artist.ArtistSubcomponent
import com.guilhermereisdev.tvguide.presentation.di.movie.MovieSubcomponent
import com.guilhermereisdev.tvguide.presentation.di.tvshow.TVShowSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        MovieSubcomponent::class,
        TVShowSubcomponent::class,
        ArtistSubcomponent::class,
    ]
)
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}
