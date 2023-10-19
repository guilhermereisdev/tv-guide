package com.guilhermereisdev.tvguide.presentation.di.core

import com.guilhermereisdev.tvguide.data.api.TMDBService
import com.guilhermereisdev.tvguide.data.repository.artist.datasource.ArtistRemoteDataSource
import com.guilhermereisdev.tvguide.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieRemoteDataSource
import com.guilhermereisdev.tvguide.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasourceimpl.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService)
    }

    @Singleton
    @Provides
    fun provideTVShowRemoteDataSource(tmdbService: TMDBService): TVShowRemoteDataSource {
        return TVShowRemoteDataSourceImpl(tmdbService)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService)
    }
}
