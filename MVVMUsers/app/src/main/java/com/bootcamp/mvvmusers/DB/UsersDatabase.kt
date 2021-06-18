package com.bootcamp.mvvmusers.DB

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.bootcamp.mvvmusers.DB.dao.UserDao
import com.bootcamp.mvvmusers.DB.entities.UserStorageEntity

@Database(entities = [UserStorageEntity::class], version = 1)
abstract class UsersDatabase():RoomDatabase() {

    abstract fun userDao():UserDao

    object NAME{
        const val DATABASE_NAME = "users_db"
    }
}