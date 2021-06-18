package com.bootcamp.mvvmusers.DB.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class UserStorageEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String
) {
}