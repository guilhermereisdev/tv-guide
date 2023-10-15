package com.guilhermereisdev.tvguide.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.guilhermereisdev.tvguide.data.model.tvshow.TVShow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShows: List<TVShow>)

    @Query("DELETE FROM tvShows")
    suspend fun deleteAllTVShows()

    @Query("SELECT * FROM tvShows")
    suspend fun getTVShows(): List<TVShow>
}
