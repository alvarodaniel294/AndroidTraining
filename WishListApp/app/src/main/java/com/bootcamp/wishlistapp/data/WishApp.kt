package com.bootcamp.wishlistapp.data

import android.app.Application
import androidx.room.Room

class WishApp: Application() {

    val room = Room.databaseBuilder(
       this,
        WishDB::class.java,
        "wishdb"
    ).build()
}