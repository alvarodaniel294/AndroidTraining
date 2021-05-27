package com.bootcamp.wishlistapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bootcamp.wishlistapp.dao.WishDao
import com.bootcamp.wishlistapp.entities.Wish

@Database (
    entities = [Wish::class],
    version = 1
)
abstract class WishDB: RoomDatabase() {

    abstract fun wishDao(): WishDao

    companion object {

        @Volatile
        private var INSTANCE: WishDB? = null

        fun getDatabase(context: Context): WishDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context, WishDB::class.java, "WishDB").build()
                INSTANCE = instance
                instance
            }
        }
    }
}