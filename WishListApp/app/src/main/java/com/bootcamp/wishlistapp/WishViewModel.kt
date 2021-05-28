package com.bootcamp.wishlistapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.wishlistapp.wishRepository.WishRepository
import kotlinx.coroutines.*

class WishViewModel (private val repository: WishRepository):ViewModel() {

    val wishList:LiveData<List<Wish>> = repository.todoList

    fun getListFromDB(application: Application):LiveData<List<Wish>>{
        val app = (application as WishApp)
        return app.wishDB.wishDao().getTodosList()
    }

    fun saveDataWithRepository(wish: Wish){
        viewModelScope.launch {
            repository.addWish(wish)
        }
    }


    fun deleteWish(wish: Wish){
        viewModelScope.launch {
            repository.deleteWish(wish)
        }
    }
}