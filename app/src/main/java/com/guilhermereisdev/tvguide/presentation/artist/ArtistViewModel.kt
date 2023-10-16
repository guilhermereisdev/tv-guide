package com.guilhermereisdev.tvguide.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.guilhermereisdev.tvguide.domain.usecase.GetArtistsUseCase
import com.guilhermereisdev.tvguide.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase,
) : ViewModel() {
    fun getArtists() = liveData {
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateArtists() = liveData {
        val artistsList = updateArtistsUseCase.execute()
        emit(artistsList)
    }
}
