package com.bootcamp.dependency.DB

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.bootcamp.dependency.DB.dao.MovieDao
import com.bootcamp.dependency.DB.entities.MovieStorageEntity

@Database(entities = [MovieStorageEntity::class], version = 1)
abstract class MoviesDatabase():RoomDatabase() {

    abstract fun movieDao():MovieDao

    object NAME{
        const val DATABASE_NAME = "movies_db"
    }
}