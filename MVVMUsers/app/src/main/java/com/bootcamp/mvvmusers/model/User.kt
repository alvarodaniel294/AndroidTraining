package com.bootcamp.mvvmusers.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "userid")val id: Long,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "username")val username: String,
    @ColumnInfo(name = "email")val email: String,
    @ColumnInfo(name = "address")val address: Address,
    @ColumnInfo(name = "phone")val phone: String,
    @ColumnInfo(name = "website")val website: String,
    @ColumnInfo(name = "company")val company: Company
)

/**
 * Optional class, you can delete the class if you want
 */
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

/**
 * Optional class, you can delete the class if you want
 */
data class Geo(
    val lat: String,
    val lng: String
)

/**
 * Optional class, you can delete the class if you want
 */
data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)
