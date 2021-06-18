package com.bootcamp.mvvmusers.model

import com.google.gson.annotations.SerializedName

data class UsersResponse(

    @SerializedName("results")
    val usersList:MutableList<User>
)
