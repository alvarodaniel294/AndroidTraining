package com.bootcamp.wishlistapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.wishlistapp.entities.Wish
import com.bootcamp.wishlistapp.repository.WishRepository
import kotlinx.coroutines.launch

class WishViewModel  (private val repository: WishRepository): ViewModel() {

    val wishList: LiveData<List<Wish>> = repository.todoList

    fun saveWish(wish: Wish) {
        viewModelScope.launch {
            repository.addWish(wish)
        }
    }

    fun editWish(wish: Wish) {
        viewModelScope.launch {
            repository.editWish(wish)
        }
    }

    fun removeWish(wish: Wish) {
        viewModelScope.launch {
            repository.removeWish(wish)
        }
    }
}