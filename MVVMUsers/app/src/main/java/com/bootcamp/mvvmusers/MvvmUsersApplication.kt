package com.bootcamp.mvvmusers

import android.app.Application
import androidx.room.Room
import com.bootcamp.mvvmusers.DB.UserDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MvvmUsersApplication :Application() {

    val room = Room.databaseBuilder(
        this,
        UserDatabase::class.java, "database-name"
    ).build()

}