package com.guilhermereisdev.tvguide.presentation

import android.app.Application
import com.guilhermereisdev.tvguide.BuildConfig
import com.guilhermereisdev.tvguide.presentation.di.Injector
import com.guilhermereisdev.tvguide.presentation.di.artist.ArtistSubcomponent
import com.guilhermereisdev.tvguide.presentation.di.core.AppComponent
import com.guilhermereisdev.tvguide.presentation.di.core.AppModule
import com.guilhermereisdev.tvguide.presentation.di.core.DaggerAppComponent
import com.guilhermereisdev.tvguide.presentation.di.core.NetModule
import com.guilhermereisdev.tvguide.presentation.di.core.RemoteDataModule
import com.guilhermereisdev.tvguide.presentation.di.movie.MovieSubcomponent
import com.guilhermereisdev.tvguide.presentation.di.tvshow.TVShowSubcomponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()
    }

    override fun createMovieSubcomponent(): MovieSubcomponent {
        return appComponent.movieSubcomponent().create()
    }

    override fun createTVShowSubcomponent(): TVShowSubcomponent {
        return appComponent.tvShowSubcomponent().create()
    }

    override fun createArtistSubcomponent(): ArtistSubcomponent {
        return appComponent.artistSubComponent().create()
    }
}