package com.bootcamp.dependency.models

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("backdrop_path")
    val path:String,
    val id:Long,
    @SerializedName("overview")
    val overview:String,
    @SerializedName("genres")
    val genres:List<Genre>



)

data class Genre(
    val id:Long,
    val name:String
) {

}
