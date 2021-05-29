package com.bootcamp.wishlistapp.data

import android.app.Application
import androidx.room.Room

class WishApp: Application() {

    val myWishDatabase by lazy {
        WishDB.getDatabase(applicationContext)
    }

}