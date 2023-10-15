package com.guilhermereisdev.tvguide.data.repository.artist.datasourceimpl

import com.guilhermereisdev.tvguide.data.model.artist.Artist
import com.guilhermereisdev.tvguide.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}
