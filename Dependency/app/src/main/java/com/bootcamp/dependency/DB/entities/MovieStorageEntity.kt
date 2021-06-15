package com.bootcamp.dependency.DB.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MovieStorageEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val language: String,
    val title: String,
    val backdropPath: String,
    val overview: String,
    val poster: String
) {
}