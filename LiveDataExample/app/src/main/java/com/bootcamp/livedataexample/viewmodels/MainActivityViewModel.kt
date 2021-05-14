package com.bootcamp.livedataexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {



    private val _title: MutableLiveData<String> = MutableLiveData()
    val title:LiveData<String> = _title

    init {
        _title.value = "default value"
    }

//    fun changeValue(){
//        val livvv:LiveData<String>
//        //title = livvv
//    }




    /**
     * @param asdfasdf
     * @return asdfasdf
     */
    fun updateTitle(){
        _title.value = "new value from viewmodel"
    }

}