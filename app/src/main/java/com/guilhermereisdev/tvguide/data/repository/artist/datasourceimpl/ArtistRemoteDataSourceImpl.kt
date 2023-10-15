package com.guilhermereisdev.tvguide.data.repository.artist.datasourceimpl

import com.guilhermereisdev.tvguide.data.api.TMDBService
import com.guilhermereisdev.tvguide.data.model.artist.ArtistList
import com.guilhermereisdev.tvguide.data.model.movie.MovieList
import com.guilhermereisdev.tvguide.data.repository.artist.datasource.ArtistRemoteDataSource
import com.guilhermereisdev.tvguide.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
    private val language: String = "pt-BR"
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> =
        tmdbService.getPopularArtists(apiKey, language)
}
