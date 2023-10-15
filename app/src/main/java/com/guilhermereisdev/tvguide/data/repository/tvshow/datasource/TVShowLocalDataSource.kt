package com.guilhermereisdev.tvguide.data.repository.tvshow.datasource

import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun saveTVShowsToDB(tvShows: List<TVShow>)
    suspend fun clearAll()
}
