package com.bootcamp.mvvmusers.DB.Dao

import androidx.room.*
import com.bootcamp.mvvmusers.DB.entities.UserStorageEntity
import com.google.gson.annotations.SerializedName

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserStorageEntity):Long
}