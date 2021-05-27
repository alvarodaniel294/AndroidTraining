package com.bootcamp.wishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Wish::class],
    version = 1
)
abstract class WishDB: RoomDatabase() {

    abstract fun wishDao(): WishDao
}