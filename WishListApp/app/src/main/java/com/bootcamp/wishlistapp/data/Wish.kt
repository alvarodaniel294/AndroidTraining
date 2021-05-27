package com.bootcamp.wishlistapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val body: String,
    val priority: String,
    val owner: String
)