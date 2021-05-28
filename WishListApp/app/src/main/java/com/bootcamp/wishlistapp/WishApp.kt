package com.bootcamp.wishlistapp

import android.app.Application
import com.bootcamp.wishlistapp.db.WishDB
import com.bootcamp.wishlistapp.repository.WishRepository

class WishApp: Application() {

    private val wishDB by lazy {
        WishDB.getDatabase(applicationContext)
    }

    val wishRepository by lazy {
        WishRepository(wishDB.wishDao())
    }
}