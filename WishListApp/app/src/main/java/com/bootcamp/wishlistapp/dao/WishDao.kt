package com.bootcamp.wishlistapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bootcamp.wishlistapp.Wish

@Dao
interface WishDao {

    @Query("SELECT * FROM Wish")
    fun getTodosList():LiveData<List<Wish>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWish(wish: Wish)

    @Delete
    fun removeWish(wish: Wish)

//    @Query("SELECT * FROM todo where :id")
//    fun getTodoListById(id:Int)
}