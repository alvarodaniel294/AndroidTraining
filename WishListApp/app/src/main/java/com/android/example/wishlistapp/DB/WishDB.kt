package com.android.example.wishlistapp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.example.wishlistapp.Dao.WishDao
import com.android.example.wishlistapp.Entities.Wish

@Database(entities = arrayOf(Wish::class), version = 1)
abstract class WishDB: RoomDatabase(){
    abstract fun wishDao(): WishDao

    companion object {
        @Volatile
        private var INSTANCE: WishDB? = null

        fun getDataBase(context: Context): WishDB{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context, WishDB::class.java, "WishDB").build()
                INSTANCE = instance
                instance
            }
        }
    }
}