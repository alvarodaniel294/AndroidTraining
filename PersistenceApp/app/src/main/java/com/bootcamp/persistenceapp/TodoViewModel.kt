package com.bootcamp.persistenceapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.persistenceapp.entities.Todo
import com.bootcamp.persistenceapp.todoRepository.TodoRepository
import kotlinx.coroutines.*

class TodoViewModel (private val repository: TodoRepository):ViewModel() {

    val todoList:LiveData<List<Todo>> = repository.todoList


    fun getListFromDB(application: Application):LiveData<List<Todo>>{
        val app = (application as TodoApp)
        return app.todoDB.todoDao().getTodosList()
    }


    fun saveData(string: String, application: Application){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val app = application.applicationContext as TodoApp
                val todoToSave = Todo(null, string, "pending")
                app.todoDB.todoDao().addTodo(todoToSave)
            }

        }

    }

    fun saveDataWithRepository(todo: Todo){
        viewModelScope.launch {
            repository.addTodo(todo)
        }
    }
}