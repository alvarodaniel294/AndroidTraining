package com.bootcamp.wishlistapp.data

interface WishListener {

    fun editWish(editWish: Wish)
    fun deleteWish(delWish: Wish)
}