package com.bootcamp.wishlistapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Wish::class],
    version = 1
)
abstract class WishDB: RoomDatabase() {

    abstract fun wishDao():WishDao

    companion object {

        @Volatile
        private var INSTANCE: WishDB? = null

        fun getDatabase(context: Context): WishDB {
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context, WishDB::class.java, "whishdb").build()
                INSTANCE = instance
                instance
            }
        }
    }
}