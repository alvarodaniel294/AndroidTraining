package com.bootcamp.wishlistapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wish(

    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    @ColumnInfo(name = "value_db")
    val wish:String,
    val priority:String,
    val owner:String
)
