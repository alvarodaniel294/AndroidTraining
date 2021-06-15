package com.bootcamp.dependency.retrofit

import com.bootcamp.dependency.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    @GET("now_playing?api_key=63592215c6c623581e3f055bca1bc8a3&language=en-US&")
    suspend fun getNowPlayingMovies(): Response<MoviesResponse>
}