package com.bootcamp.coroutinesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {


    fun coroutinesInViewModel(){
        viewModelScope.launch {

        }
    }
}