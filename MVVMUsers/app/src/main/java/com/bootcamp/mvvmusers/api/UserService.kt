package com.bootcamp.mvvmusers.api

import com.bootcamp.mvvmusers.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}