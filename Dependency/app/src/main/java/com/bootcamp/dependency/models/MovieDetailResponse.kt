package com.bootcamp.dependency.models

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    val id:Long,
    @SerializedName("overview")
    val overview:String,
    @SerializedName("genres")
    val genres:List<Genre>,
    @SerializedName("original_title")
    val originalTitle:String,
    @SerializedName("backdrop_path")
    val backdropPath:String,
    @SerializedName("poster_path")
    val posterPath:String,
    @SerializedName("vote_average")
    val voteAverage:Double,
    @SerializedName("vote_count")
    val voteCount:Int

){
    data class Genre(
        val id:Long,
        val name:String
    ) {

    }
}


