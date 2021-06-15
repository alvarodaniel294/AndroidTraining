package com.bootcamp.dependency.models

import com.google.gson.annotations.SerializedName


data class MoviesResponse(

    @SerializedName("results")
    val moviesList:MutableList<MovieResponse>
)
