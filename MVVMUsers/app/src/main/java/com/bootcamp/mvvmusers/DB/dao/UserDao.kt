package com.bootcamp.mvvmusers.DB.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bootcamp.mvvmusers.DB.entities.UserStorageEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(movie: UserStorageEntity):Long

    @Query("SELECT * FROM UserStorageEntity")
    suspend fun getUsers():List<UserStorageEntity>
}