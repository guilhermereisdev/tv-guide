package com.guilhermereisdev.tvguide.data.repository.tvshow.datasource

import com.guilhermereisdev.tvguide.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowList>
}
