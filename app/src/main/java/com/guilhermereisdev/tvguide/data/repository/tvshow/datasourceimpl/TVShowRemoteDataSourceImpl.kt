package com.guilhermereisdev.tvguide.data.repository.tvshow.datasourceimpl

import com.guilhermereisdev.tvguide.data.api.TMDBService
import com.guilhermereisdev.tvguide.data.model.tvshow.TVShowList
import com.guilhermereisdev.tvguide.data.repository.tvshow.datasource.TVShowRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
    private val language: String = "pt-BR"
) : TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> =
        tmdbService.getPopularTVShows(apiKey, language)
}
