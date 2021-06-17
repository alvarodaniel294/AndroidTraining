package com.bootcamp.dependency.DB.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bootcamp.dependency.DB.entities.MovieStorageEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: MovieStorageEntity):Long

    @Query("SELECT * FROM moviestorageentity")
    suspend fun getMoviesNowPlaying():List<MovieStorageEntity>

}