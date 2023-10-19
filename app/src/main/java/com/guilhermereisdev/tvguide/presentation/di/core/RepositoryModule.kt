package com.guilhermereisdev.tvguide.presentation.di.core

import com.guilhermereisdev.tvguide.data.repository.artist.ArtistRepositoryImpl
import com.guilhermereisdev.tvguide.data.repository.artist.datasource.ArtistCacheDataSource
import com.guilhermereisdev.tvguide.data.repository.artist.datasource.ArtistLocalDataSource
import com.guilhermereisdev.tvguide.data.repository.artist.datasource.ArtistRemoteDataSource
import com.guilhermereisdev.tvguide.data.repository.movie.MovieRepositoryImpl
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieCacheDataSource
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieLocalDataSource
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieRemoteDataSource
import com.guilhermereisdev.tvguide.data.repository.tvshow.TVShowRepositoryImpl
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.guilhermereisdev.tvguide.domain.repository.ArtistRepository
import com.guilhermereisdev.tvguide.domain.repository.MovieRepository
import com.guilhermereisdev.tvguide.domain.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource,
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource,
        )
    }

    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource,
    ): TVShowRepository {
        return TVShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource,
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource,
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource,
        )
    }
}
