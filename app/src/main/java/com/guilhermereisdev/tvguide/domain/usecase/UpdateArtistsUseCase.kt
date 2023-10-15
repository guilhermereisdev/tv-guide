package com.guilhermereisdev.tvguide.domain.usecase

import com.guilhermereisdev.tvguide.data.model.artist.Artist
import com.guilhermereisdev.tvguide.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}
