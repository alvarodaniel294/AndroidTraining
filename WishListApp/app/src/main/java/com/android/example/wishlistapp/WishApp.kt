package com.android.example.wishlistapp

import android.app.Application
import com.android.example.wishlistapp.DB.WishDB

class WishApp: Application() {

    val wishDB by lazy {
        WishDB.getDataBase(applicationContext)
    }
}