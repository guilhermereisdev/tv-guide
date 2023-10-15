package com.guilhermereisdev.tvguide.data.repository.artist.datasource

import com.guilhermereisdev.tvguide.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}
