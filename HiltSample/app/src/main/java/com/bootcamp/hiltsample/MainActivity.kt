package com.bootcamp.hiltsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    @Inject
    lateinit var someClass2: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivityDaggerHilt", someClass.doSomething())
        Log.d("MainActivityDaggerHilt", someClass.withOtherClass())

    }
}


class SomeClass
@Inject
constructor(
    val otherClass: OtherClass
){

    fun doSomething():String {
        return  "doing Something"
    }

    fun withOtherClass():String {
        return otherClass.doOtherThing()
    }
}

class OtherClass
@Inject
constructor() {
    fun doOtherThing(): String {
        return  "do other stuff"
    }
}