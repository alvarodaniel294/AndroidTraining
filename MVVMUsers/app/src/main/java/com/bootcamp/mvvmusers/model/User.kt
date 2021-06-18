package com.bootcamp.mvvmusers.model

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("address") val address: Address,
    @SerializedName("phone") val phone: String,
    @SerializedName("website") val website: String,
    @SerializedName("company") val company: Company
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
