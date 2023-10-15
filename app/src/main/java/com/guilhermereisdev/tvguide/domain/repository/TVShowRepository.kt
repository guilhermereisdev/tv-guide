package com.guilhermereisdev.tvguide.domain.repository

import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow

interface TVShowRepository {
    suspend fun getTVShows(): List<TVShow>?
    suspend fun updateTVShows(): List<TVShow>?
}
