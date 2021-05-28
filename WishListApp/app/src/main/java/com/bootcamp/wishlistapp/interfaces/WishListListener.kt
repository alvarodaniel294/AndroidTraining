package com.bootcamp.wishlistapp.interfaces

import com.bootcamp.wishlistapp.entities.Wish

interface WishListListener {
    fun didEditPressed(wish: Wish)
    fun didRemovePressed(wish: Wish)
}