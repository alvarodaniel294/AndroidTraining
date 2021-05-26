package com.bootcamp.persistenceapp

import android.app.Application
import com.bootcamp.persistenceapp.DB.TodoDB
import com.bootcamp.persistenceapp.todoRepository.TodoRepository

class TodoApp: Application() {

    val todoDB by lazy {
        TodoDB.getDatabase(applicationContext)
    }

    val todoRepository by lazy {
        TodoRepository(todoDB.todoDao())
    }
}