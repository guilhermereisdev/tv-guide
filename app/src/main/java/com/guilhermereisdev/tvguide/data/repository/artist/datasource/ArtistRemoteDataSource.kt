package com.guilhermereisdev.tvguide.data.repository.artist.datasource

import com.guilhermereisdev.tvguide.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}
