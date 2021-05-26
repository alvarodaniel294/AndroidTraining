package com.bootcamp.persistenceapp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.bootcamp.persistenceapp.dao.TodoDao
import com.bootcamp.persistenceapp.entities.Todo

@Database(entities = arrayOf(Todo::class), version = 4)
abstract class TodoDB: RoomDatabase() {



    abstract fun todoDao():TodoDao



    companion object {

        @Volatile
        private var INSTANCE: TodoDB? = null

        fun getDatabase(context: Context): TodoDB {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context, TodoDB::class.java, "TodoDB").build()
                INSTANCE = instance
                instance
            }
        }
    }
}