package com.bootcamp.persistenceapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bootcamp.persistenceapp.entities.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getTodosList():List<Todo>

    @Insert
    fun addTodo(todo: Todo)

    @Delete
    fun removeTodo(todo: Todo)
}