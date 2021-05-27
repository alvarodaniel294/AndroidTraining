package com.android.example.wishlistapp.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    @ColumnInfo(name = "value_db")
    val value: String,
    val priority: String,
    val owner: String
)
