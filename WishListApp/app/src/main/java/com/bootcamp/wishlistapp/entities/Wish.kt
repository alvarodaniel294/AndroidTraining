package com.bootcamp.wishlistapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wish (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    var text: String,
    var priority: String,
    var owner: String,
)