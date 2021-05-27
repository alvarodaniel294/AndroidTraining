package com.bootcamp.wishlistapp.viewmodelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bootcamp.wishlistapp.WishViewModel
import com.bootcamp.wishlistapp.wishRepository.WishRepository

class WishViewModelFactory(private val repository: WishRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WishViewModel(repository) as T
    }
}