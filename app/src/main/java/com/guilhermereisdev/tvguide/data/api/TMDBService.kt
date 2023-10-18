package com.guilhermereisdev.tvguide.data.api

import com.guilhermereisdev.tvguide.data.model.artist.ArtistList
import com.guilhermereisdev.tvguide.data.model.movie.MovieList
import com.guilhermereisdev.tvguide.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(
        @Query("language") language: String,
    ): Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query("language") language: String,
    ): Response<ArtistList>

}
