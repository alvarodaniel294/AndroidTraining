package com.bootcamp.mvvmusers.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitSingleton {

    private var retrofit: RetrofitSingleton? = null

    private val BASEURL: String = ""

    fun getRetrofitInstance(): RetrofitSingleton{
        if( retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

}