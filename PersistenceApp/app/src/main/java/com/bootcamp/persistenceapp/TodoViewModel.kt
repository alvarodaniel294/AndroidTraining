package com.bootcamp.persistenceapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.persistenceapp.entities.Todo
import kotlinx.coroutines.*

class TodoViewModel:ViewModel() {

    val _todoList:MutableLiveData<List<Todo>> = MutableLiveData()
    val todoList:LiveData<List<Todo>> = _todoList


    fun getList(application: Application){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val app = application.applicationContext as TodoApp
                val listTodo = app.todoDB.todoDao().getTodosList()
                withContext(Dispatchers.Main){

                }
            }
        }
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
}