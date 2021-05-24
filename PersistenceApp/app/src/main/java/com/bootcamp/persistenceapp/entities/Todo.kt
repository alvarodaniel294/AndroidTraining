package com.bootcamp.persistenceapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "value_db")
    val value:String,
    val states:String
)
