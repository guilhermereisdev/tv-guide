package com.guilhermereisdev.tvguide.presentation.di.core

import com.guilhermereisdev.tvguide.presentation.di.artist.ArtistSubcomponent
import com.guilhermereisdev.tvguide.presentation.di.movie.MovieSubcomponent
import com.guilhermereisdev.tvguide.presentation.di.tvshow.TVShowSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class,
    ]
)
interface AppComponent {
    fun movieSubcomponent(): MovieSubcomponent.Factory
    fun tvShowSubcomponent(): TVShowSubcomponent.Factory
    fun artistSubComponent(): ArtistSubcomponent.Factory
}
