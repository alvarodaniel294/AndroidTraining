package com.bootcamp.dependency.retrofit

import com.bootcamp.dependency.models.MovieDetailResponse
import com.bootcamp.dependency.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("now_playing?api_key=63592215c6c623581e3f055bca1bc8a3&language=en-US&")
    suspend fun getNowPlayingMovies(): Response<MoviesResponse>

    @GET("https://api.themoviedb.org/3/movie/{id}?api_key=63592215c6c623581e3f055bca1bc8a3&language=en-US")
    suspend fun getMovieDetail(@Path ("id") id:Long):Response<MovieDetailResponse>

    @GET("https://api.themoviedb.org/3/movie/upcoming?api_key=63592215c6c623581e3f055bca1bc8a3&language=en-US")
    suspend fun getUpComingMovies():Response<MoviesResponse>

    @GET("https://api.themoviedb.org/3/movie/top_rated?api_key=63592215c6c623581e3f055bca1bc8a3&language=en-US")
    suspend fun getTopRatedMovies():Response<MoviesResponse>
}