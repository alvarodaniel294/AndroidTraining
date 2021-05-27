package com.bootcamp.wishlistapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bootcamp.wishlistapp.entities.Wish

@Dao
interface WishDao {

    @Query("SELECT * FROM Wish")
    suspend fun getWishList(): List<Wish>

    @Insert
    suspend fun addWish(wish: Wish)

    @Delete
    suspend fun removeWish(wish: Wish)

}