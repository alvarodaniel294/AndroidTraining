package com.bootcamp.wishlistapp.listener

interface WishListener {
    fun onRemoveItem(index: Int)
    fun onEditItem(index: Int)
}