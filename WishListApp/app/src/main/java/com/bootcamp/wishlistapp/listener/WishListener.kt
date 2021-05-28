package com.bootcamp.wishlistapp.listener

import com.bootcamp.wishlistapp.Wish

interface WishListener {
    fun onRemoveItem(wish: Wish)
    fun onEditItem(wish: Wish)
}