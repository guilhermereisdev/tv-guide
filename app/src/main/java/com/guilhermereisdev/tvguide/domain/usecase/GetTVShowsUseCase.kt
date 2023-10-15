package com.guilhermereisdev.tvguide.domain.usecase

import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow
import com.guilhermereisdev.tvguide.domain.repository.TVShowRepository

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute(): List<TVShow>? = tvShowRepository.getTVShows()
}
