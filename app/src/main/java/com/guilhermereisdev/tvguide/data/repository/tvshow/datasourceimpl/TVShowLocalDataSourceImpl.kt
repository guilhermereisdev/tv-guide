package com.guilhermereisdev.tvguide.data.repository.tvshow.datasourceimpl

import com.guilhermereisdev.tvguide.data.db.TVShowDao
import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao) : TVShowLocalDataSource {
    override suspend fun getTVShowsFromDB(): List<TVShow> {
        return tvShowDao.getTVShows()
    }

    override suspend fun saveTVShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTVShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTVShows()
        }
    }
}
