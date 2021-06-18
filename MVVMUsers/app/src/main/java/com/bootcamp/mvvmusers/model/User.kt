package com.bootcamp.mvvmusers.model

import com.google.gson.annotations.SerializedName


data class User(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)
data class UserList(
    val userList: MutableList<User>
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
