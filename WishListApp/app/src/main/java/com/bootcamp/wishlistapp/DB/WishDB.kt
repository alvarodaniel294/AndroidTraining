package com.bootcamp.wishlistapp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bootcamp.wishlistapp.Wish
import com.bootcamp.wishlistapp.dao.WishDao


@Database(entities = arrayOf(Wish::class), version = 4)
abstract class WishDB: RoomDatabase() {

    abstract fun wishDao():WishDao

    companion object {

        @Volatile
        private var INSTANCE: WishDB? = null

        fun getDatabase(context: Context): WishDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context, WishDB::class.java, "WishDB").allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}