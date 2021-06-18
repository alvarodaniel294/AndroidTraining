package com.bootcamp.mvvmusers.retrofit

import com.bootcamp.mvvmusers.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UsersService {
    @GET("users")
    suspend fun getAllUsers(): Response<List<User>>
}