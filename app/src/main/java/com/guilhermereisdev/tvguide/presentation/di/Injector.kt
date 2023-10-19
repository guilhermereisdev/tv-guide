package com.guilhermereisdev.tvguide.presentation.di

import com.guilhermereisdev.tvguide.presentation.di.artist.ArtistSubcomponent
import com.guilhermereisdev.tvguide.presentation.di.movie.MovieSubcomponent
import com.guilhermereisdev.tvguide.presentation.di.tvshow.TVShowSubcomponent

interface Injector {
    fun createMovieSubcomponent(): MovieSubcomponent
    fun createTVShowSubcomponent(): TVShowSubcomponent
    fun createArtistSubcomponent(): ArtistSubcomponent
}
