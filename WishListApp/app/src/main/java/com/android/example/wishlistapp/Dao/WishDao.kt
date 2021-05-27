package com.android.example.wishlistapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.example.wishlistapp.Entities.Wish

@Dao
interface WishDao {

    @Query("SELECT * FROM Wish")
    fun getWishList(): LiveData<List<Wish>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWish(wish: Wish)

    @Delete
    fun removeWish(wish: Wish)

}