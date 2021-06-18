package com.bootcamp.mvvmusers.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bootcamp.mvvmusers.model.Address
import com.bootcamp.mvvmusers.model.Company

@Entity
data class UserEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)