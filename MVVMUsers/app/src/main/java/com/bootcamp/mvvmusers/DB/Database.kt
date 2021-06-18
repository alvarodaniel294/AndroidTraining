package com.bootcamp.mvvmusers.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    fun getDatabase2(context: Context): UserDatabase{
        val db = Room.databaseBuilder(
            context.applicationContext,
            UserDatabase::class.java, "database-name"
        ).build()
        return db
    }

    @Volatile
    private var INSTANCE: UserDatabase? = null

    fun getDatabase(context: Context): UserDatabase {
        if( INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "userdatabase"
            ).build()
        }
        return INSTANCE as UserDatabase
    }
}