package com.guilhermereisdev.tvguide.domain.repository

import com.guilhermereisdev.tvguide.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}
