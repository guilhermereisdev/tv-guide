package com.guilhermereisdev.tvguide.presentation.di.core

import com.guilhermereisdev.tvguide.data.repository.artist.datasource.ArtistCacheDataSource
import com.guilhermereisdev.tvguide.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieCacheDataSource
import com.guilhermereisdev.tvguide.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasourceimpl.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCacheDataSource(): TVShowCacheDataSource {
        return TVShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}
