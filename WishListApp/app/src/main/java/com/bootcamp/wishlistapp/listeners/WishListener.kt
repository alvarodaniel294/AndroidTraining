package com.bootcamp.wishlistapp.listeners

import com.bootcamp.wishlistapp.entities.Wish

interface WishListener {
    fun deleteWishItem(wish: Wish)
    fun editWishItem(wish: Wish)
}