package com.bootcamp.retrofitapplication.postRepository

import androidx.lifecycle.MutableLiveData
import com.bootcamp.retrofitapplication.apiHelper.RetrofitSingleton
import com.bootcamp.retrofitapplication.models.PostItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException

class PostRepository {

    object PostRepositoryObject {
        var INSTANCE: PostRepository? = null
        fun getInstance(): PostRepository {
            if (INSTANCE == null) {
                INSTANCE = PostRepository()
                return INSTANCE as PostRepository
            } else {
                return INSTANCE as PostRepository
            }
        }
    }


    fun getPosts(): MutableLiveData<List<PostItem>> {
        val mutableList: MutableLiveData<List<PostItem>> = MutableLiveData()

        RetrofitSingleton.api.getPosts().enqueue(object : Callback<List<PostItem>> {
            override fun onResponse(
                call: Call<List<PostItem>>,
                response: Response<List<PostItem>>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        mutableList.value = it
                    }
                }
            }

            override fun onFailure(call: Call<List<PostItem>>, t: Throwable) {


            }
        })
        return mutableList
    }
}