package com.bootcamp.wishlistapp

import android.app.Application
import com.bootcamp.wishlistapp.databases.WishDatabase

class WishApp: Application() {
    val todoDatabase by lazy {
        WishDatabase.getDatabase(applicationContext)
    }
}