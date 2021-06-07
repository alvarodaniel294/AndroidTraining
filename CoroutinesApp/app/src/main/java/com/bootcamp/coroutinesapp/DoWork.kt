package com.bootcamp.coroutinesapp

import android.util.Log
import kotlinx.coroutines.delay

object DoWork {


    fun doHardWork(){

        Thread.sleep(4000)

        Log.d(MainActivity.TAG, "doing some hard work")

    }

    suspend fun printStatus(){
        Log.d(MainActivity.TAG, "In print status function")
        while (true){
            delay(3000L)
            Log.d(MainActivity.TAG, "status active global scope")
        }
    }
}