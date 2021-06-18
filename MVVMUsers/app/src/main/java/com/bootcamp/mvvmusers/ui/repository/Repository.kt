package com.bootcamp.mvvmusers.ui.repository

import android.content.Context
import com.bootcamp.mvvmusers.api.RetrofitSingleton
import com.bootcamp.mvvmusers.model.User
import retrofit2.Response
import retrofit2.Retrofit

class Repository {
    suspend fun getUsers(): Response<List<User>>{
        return RetrofitSingleton.api.getUsers()
    }
}