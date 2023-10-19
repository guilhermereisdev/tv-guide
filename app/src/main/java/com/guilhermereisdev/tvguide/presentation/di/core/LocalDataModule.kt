package com.guilhermereisdev.tvguide.presentation.di.core

import com.guilhermereisdev.tvguide.data.db.ArtistDao
import com.guilhermereisdev.tvguide.data.db.MovieDao
import com.guilhermereisdev.tvguide.data.db.TVShowDao
import com.guilhermereisdev.tvguide.data.repository.artist.datasource.ArtistLocalDataSource
import com.guilhermereisdev.tvguide.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieLocalDataSource
import com.guilhermereisdev.tvguide.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasourceimpl.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource {
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}
