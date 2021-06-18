package com.bootcamp.mvvmusers.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitSingleton {

    lateinit var retrofit: Retrofit

    private val BASEURL: String = "https://jsonplaceholder.typicode.com/"

    fun getRetrofitInstance(): Retrofit?{
        if( retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

}