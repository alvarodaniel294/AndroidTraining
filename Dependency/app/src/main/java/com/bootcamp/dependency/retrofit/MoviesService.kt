package com.bootcamp.dependency.retrofit

import com.bootcamp.dependency.models.MoviesResponse

interface MoviesService {



    suspend fun getNowPlayingMovies(): MoviesResponse
}