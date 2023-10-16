package com.guilhermereisdev.tvguide.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.guilhermereisdev.tvguide.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM artists")
    fun deleteAllArtists()

    @Query("SELECT * FROM artists")
    fun getArtists(): List<Artist>
}
