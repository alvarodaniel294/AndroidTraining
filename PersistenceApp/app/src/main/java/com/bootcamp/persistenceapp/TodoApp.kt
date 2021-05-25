package com.bootcamp.persistenceapp

import android.app.Application
import com.bootcamp.persistenceapp.DB.TodoDB

class TodoApp: Application() {

    val todoDB by lazy {
        TodoDB.getDatabase(applicationContext)
    }
}