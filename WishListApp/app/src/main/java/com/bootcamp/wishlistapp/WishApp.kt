package com.bootcamp.wishlistapp

import android.app.Application
import com.bootcamp.wishlistapp.DB.WishDB
import com.bootcamp.wishlistapp.wishRepository.WishRepository


class WishApp: Application() {

    val wishDB by lazy {
        WishDB.getDatabase(applicationContext)
    }

    val wishRepository by lazy {
        WishRepository(wishDB.wishDao())
    }
}