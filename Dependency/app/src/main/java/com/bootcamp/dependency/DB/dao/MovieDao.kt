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

    @Query("SELECT * FROM MovieStorageEntity WHERE isNowPlaying = 1")
    suspend fun getMoviesNowPlaying():List<MovieStorageEntity>

    @Query("SELECT * FROM MovieStorageEntity WHERE isUpcoming = 1")
    suspend fun getUpcomingMovies():List<MovieStorageEntity>

    @Query("SELECT * FROM MovieStorageEntity WHERE isTopRated = 1")
    suspend fun getTopRatedMovies():List<MovieStorageEntity>
}