package com.bootcamp.persistenceapp.todoRepository

import androidx.annotation.Nullable
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bootcamp.persistenceapp.dao.TodoDao
import com.bootcamp.persistenceapp.entities.Todo

class TodoRepository( private val dao:TodoDao) {

    val todoList:LiveData<List<Todo>> = dao.getTodosList()


    @WorkerThread
    suspend fun addTodo(todo: Todo){
        dao.addTodo(todo)
    }

    fun updateTodo(todo: Todo){

    }

}