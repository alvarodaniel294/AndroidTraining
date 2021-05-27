package com.bootcamp.wishlistapp.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.wishlistapp.WishApp
import com.bootcamp.wishlistapp.entities.Wish
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    fun getListFromDatabase(application: Application): LiveData<List<Wish>> {
        val app = (application as WishApp)
        return app.todoDatabase.wishDao().getWishList()
    }

    fun saveWish(wishToSave: Wish, application: Application){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val app = application.applicationContext as WishApp
                app.todoDatabase.wishDao().addWish(wishToSave)
            }
        }
    }
}