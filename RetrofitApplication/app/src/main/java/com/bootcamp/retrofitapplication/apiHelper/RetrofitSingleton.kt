package com.bootcamp.retrofitapplication.apiHelper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {

    val api:PostServices by lazy {
        Retrofit
            .Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostServices::class.java)
    }
}