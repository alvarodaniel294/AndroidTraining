package com.bootcamp.retrofitapplication.models

import com.google.gson.annotations.SerializedName

data class PostItem(
    val userId:Int?,
    val id:Int?,
    val title:String?,

    @SerializedName("body")
    val description:String?
)
