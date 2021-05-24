package com.bootcamp.persistenceapp.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bootcamp.persistenceapp.entities.Todo

@Database(entities = arrayOf(Todo::class), version = 2)
abstract class TodoDB: RoomDatabase() {
}