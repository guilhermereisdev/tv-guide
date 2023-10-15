package com.guilhermereisdev.tvguide.domain.usecase

import com.guilhermereisdev.tvguide.data.model.artist.Artist
import com.guilhermereisdev.tvguide.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}
