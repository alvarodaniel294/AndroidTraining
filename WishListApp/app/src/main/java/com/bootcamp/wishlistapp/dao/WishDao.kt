package com.bootcamp.wishlistapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bootcamp.wishlistapp.entities.Wish

@Dao
interface WishDao {

    @Query("SELECT * FROM Wish")
    fun getWishList(): LiveData<List<Wish>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWish(wish: Wish)

    @Update
    suspend fun editWish(wish: Wish)

    @Delete
    suspend fun removeWish(wish: Wish)

}