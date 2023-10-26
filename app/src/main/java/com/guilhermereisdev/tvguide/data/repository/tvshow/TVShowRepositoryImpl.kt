package com.guilhermereisdev.tvguide.data.repository.tvshow

import android.util.Log
import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.guilhermereisdev.tvguide.domain.repository.TVShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource,
) : TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? {
        return getTVShowsFromCache()
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        val newListOfTVShows = getTVShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowsToDB(newListOfTVShows)
        tvShowCacheDataSource.saveTVShowsToCache(newListOfTVShows)

        return newListOfTVShows
    }

    suspend fun getTVShowsFromAPI(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>

        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()

            if (body != null) {
                tvShowList = body.TVShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return tvShowList
    }

    suspend fun getTVShowsFromDB(): List<TVShow> {
        var tvShowList: List<TVShow> = emptyList()

        try {
            tvShowList = tvShowLocalDataSource.getTVShowsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTVShowsFromAPI()
            tvShowLocalDataSource.saveTVShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTVShowsFromCache(): List<TVShow>? {
        lateinit var tvShowList: List<TVShow>

        try {
            tvShowList = tvShowCacheDataSource.getTVShowsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTVShowsFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShowList)
        }

        return tvShowList
    }
}
