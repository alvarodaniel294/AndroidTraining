package com.bootcamp.wishlistapp.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.bootcamp.wishlistapp.dao.WishDao
import com.bootcamp.wishlistapp.entities.Wish

class WishRepository(private val dao: WishDao) {

    val todoList: LiveData<List<Wish>> = dao.getWishList()

    @WorkerThread
    suspend fun addWish(wish: Wish) {
        dao.addWish(wish)
    }

    @WorkerThread
    suspend fun editWish(wish: Wish) {
        dao.editWish(wish)
    }

    @WorkerThread
    suspend fun removeWish(wish: Wish) {
        dao.removeWish(wish)
    }

}