package com.bootcamp.wishlistapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WishViewModel: ViewModel() {

    fun getAllWishesFromDatabase(app: Application): LiveData<List<Wish>>{
        val myApp = (app as WishApp)
        return myApp.myWishDatabase.wishDao().getAllWishes()
    }

    fun saveNewWish(newWish: Wish, app: Application){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val myApp = (app as WishApp)
                myApp.myWishDatabase.wishDao().insertWish(newWish)
            }
        }
    }

    fun deleteWish(delWish: Wish, app: Application){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val myApp = (app as WishApp)
                myApp.myWishDatabase.wishDao().deleteWish(delWish)
            }
        }
    }
}