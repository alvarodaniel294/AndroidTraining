package com.bootcamp.wishlistapp.wishRepository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.bootcamp.wishlistapp.Wish
import com.bootcamp.wishlistapp.dao.WishDao

class WishRepository(private val dao:WishDao) {

    val todoList:LiveData<List<Wish>> = dao.getTodosList()


    @WorkerThread
    suspend fun addWish(wish: Wish){
        dao.addWish(wish)
    }

    @WorkerThread
    suspend fun updateWish(wish: Wish){
        dao.addWish(wish)
    }

    @WorkerThread
    fun deleteWish(wish: Wish){
        dao.removeWish(wish)
    }
}