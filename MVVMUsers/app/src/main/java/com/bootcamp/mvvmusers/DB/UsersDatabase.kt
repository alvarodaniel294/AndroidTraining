package com.bootcamp.mvvmusers.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bootcamp.mvvmusers.DB.Dao.UserDao
import com.bootcamp.mvvmusers.DB.entities.UserStorageEntity

@Database(entities = [UserStorageEntity::class], version = 1)
abstract class MoviesDatabase(): RoomDatabase() {

    abstract fun movieDao():UserDao

    object NAME{
        const val DATABASE_NAME = "users_db"
    }
}