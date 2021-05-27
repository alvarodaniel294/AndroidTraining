package com.bootcamp.retrofitapplication.apiHelper

import com.bootcamp.retrofitapplication.models.CommentItem
import com.bootcamp.retrofitapplication.models.PostItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PostServices {

    @GET("posts")
    fun getPosts(): Call<List<PostItem>>


    @GET("comments")
    fun getCommentByPostId(
        @Query("postId") somePostId: Int,
        @Query("asdf") asdf: Int
    ): Call<List<CommentItem>>


//    @POST("SOMEDATA")
//    fun uploaddata(@Body postItem: PostItem):Call<List<PostItem>>
}