package com.bootcamp.dependency.models

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val id:Long,
    @SerializedName("original_language")
    val language:String,
    @SerializedName("original_title")
    val title:String,
    @SerializedName("backdrop_path")
    val backdropPath:String,
    @SerializedName("overview")
    val overview:String,
    @SerializedName("poster_path")
    val poster:String
)
