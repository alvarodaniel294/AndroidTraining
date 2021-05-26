package com.bootcamp.persistenceapp.viewmodelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bootcamp.persistenceapp.TodoViewModel
import com.bootcamp.persistenceapp.todoRepository.TodoRepository

class TodoViewModelFactory(private val repository: TodoRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoViewModel(repository) as T
    }
}