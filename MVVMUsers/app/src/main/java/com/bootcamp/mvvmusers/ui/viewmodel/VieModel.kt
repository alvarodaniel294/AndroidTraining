package com.bootcamp.mvvmusers.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bootcamp.mvvmusers.model.User
import com.bootcamp.mvvmusers.ui.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class VieModel: ViewModel() {

    val users = MutableLiveData<List<User>>()
    val repository = Repository()

    fun getUsers(){
        CoroutineScope(Dispatchers.IO).launch {
            val service: Response<List<User>> = repository.getUsers()
            if(service.isSuccessful) {
                val response = service.body()
                response?.let {
                    withContext(Dispatchers.Main) {
                        users.postValue(it)
                    }
                }
            }
        }
    }
}