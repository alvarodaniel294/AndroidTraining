package com.bootcamp.persistenceapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bootcamp.persistenceapp.entities.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getTodosList():LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todo: Todo)

    @Delete
    fun removeTodo(todo: Todo)

//    @Query("SELECT * FROM todo where :id")
//    fun getTodoListById(id:Int)
}