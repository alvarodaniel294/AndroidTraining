package com.bootcamp.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WishDao {

    @Query("SELECT * FROM wish")
    fun getAllWishes(): List<Wish>

    @Insert
    fun insertWish(wish: Wish)

    @Delete
    fun deleteWish(wish: Wish)
}