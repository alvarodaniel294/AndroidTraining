package com.bootcamp.mvvmusers

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bootcamp.mvvmusers.DB.UserDatabase
import com.bootcamp.mvvmusers.Retrofit.RetrofitSingleton
import com.bootcamp.mvvmusers.Retrofit.UserApi
import com.bootcamp.mvvmusers.Retrofit.UserService
import com.bootcamp.mvvmusers.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class UserViewModel: ViewModel() {

    var users = MutableLiveData<List<User>>()

    fun getUsers(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitSingleton().getRetrofitInstance()?.create(UserService::class.java)?.getUsers()
            val myUsers = call?.body()
            withContext(Dispatchers.Main){
                if (call != null) {
                    if( call.isSuccessful ){
                        myUsers.let {
                            users.postValue(it)
                            //TODO: insertar a la base de datos

                        }
                    }else{
                        // something bad happened in the server side or not found
                    }
                }
            }
        }
    }

}