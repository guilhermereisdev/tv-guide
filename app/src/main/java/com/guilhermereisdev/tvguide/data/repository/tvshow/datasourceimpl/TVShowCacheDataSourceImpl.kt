package com.guilhermereisdev.tvguide.data.repository.tvshow.datasourceimpl

import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowCacheDataSource

class TVShowCacheDataSourceImpl: TVShowCacheDataSource {
    private var tvShowList = ArrayList<TVShow>()
    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShowList
    }

    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}
