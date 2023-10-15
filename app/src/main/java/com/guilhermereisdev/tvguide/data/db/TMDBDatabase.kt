package com.guilhermereisdev.tvguide.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.guilhermereisdev.tvguide.data.model.artist.Artist
import com.guilhermereisdev.tvguide.data.model.movie.Movie
import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow

@Database(
    entities = [Movie::class, TVShow::class, Artist::class],
    version = 1,
    exportSchema = false,
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TVShowDao
    abstract fun artistDao(): ArtistDao
}
