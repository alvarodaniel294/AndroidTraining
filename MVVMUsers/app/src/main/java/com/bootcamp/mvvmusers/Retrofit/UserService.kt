package com.bootcamp.mvvmusers.Retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface UserService {
    @GET("users")
    suspend fun getUsers(): Response<List<UserApi.UserApiItem>>
}

