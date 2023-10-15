package com.guilhermereisdev.tvguide.data.repository.tvshow.datasource

import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow

interface TVShowCacheDataSource {
    suspend fun getTVShowsFromCache(): List<TVShow>
    suspend fun saveTVShowsToCache(tvShows: List<TVShow>)
}
