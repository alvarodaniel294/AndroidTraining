package com.bootcamp.mvvmusers.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bootcamp.mvvmusers.database.dao.UserDao
import com.bootcamp.mvvmusers.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase(): RoomDatabase() {

    abstract fun movieDao(): UserDao

    object NAME{
        const val DATABASE_NAME = "users"
    }
}