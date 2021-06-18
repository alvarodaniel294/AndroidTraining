package com.bootcamp.mvvmusers.Retrofit

import com.bootcamp.mvvmusers.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface UserService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}

