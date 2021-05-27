package com.bootcamp.wishlistapp.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bootcamp.wishlistapp.entities.Wish

@Dao
interface WishDao {

    @Query("SELECT * FROM Wish")
    fun getWishList(): LiveData<List<Wish>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWish(wish: Wish)

    @Delete
    fun removeWish(wish: Wish)
}