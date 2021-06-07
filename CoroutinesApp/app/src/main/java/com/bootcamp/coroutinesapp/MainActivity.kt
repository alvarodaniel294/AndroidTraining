package com.bootcamp.coroutinesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import java.util.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.workBtn).setOnClickListener {

            //coroutines2()

            runBlockingExample()


        }
    }

    suspend fun task1(){
        delay(2000L)
        Log.d(TAG, "ON TASK 1")
    }

    suspend fun task2(){
        Log.d(TAG, "ON TASK 2")

    }

    private fun coroutines1(){

        GlobalScope.launch(Dispatchers.IO) {


//                withContext(Dispatchers.IO){
//                    DoWork.doHardWork()
//                }


//                DoWork.printStatus()

            task1()
            //task2()
            withContext(Dispatchers.Main){
                Toast.makeText(this@MainActivity, "on io", Toast.LENGTH_LONG).show()
            }

        }
        GlobalScope.launch {
            task2()
        }

//            startActivity(Intent(this, EmptyActivity::class.java))
//            finish()

    }

    private fun coroutines2(){

        val job = GlobalScope.launch {

            while (true){
                if (isActive){
                    Log.d(TAG, "COROUTINE WORKING ${Date()}")
                }
            }
        }



        runBlocking {
            task2()
            delay(5000L)
            Log.d(TAG, "will stop job")
            job.cancel()
        }



    }

    private fun runBlockingExample(){
        Log.d(TAG, "BEFORE RUN BLOCKING")

        runBlocking {

            launch (Dispatchers.IO) {
                val time = measureTimeMillis {
                    val res = async { request1() }
                    val res2 = async { request2() }

                    Log.d(TAG, "the response is  ${res.await()}   -----    ${res2.await()} ")

                }
                Log.d(TAG, "with time in milis $time ")


            }

//            Log.d(TAG, "START RUN BLOCKING")
//            delay( 7000L)
//            Log.d(TAG, "end RUN BLOCKING")

        }

        Log.d(TAG, "AFTER RUN BLOCKING")


    }


    suspend fun request1():String{
        delay(3000L)
        return "request1Response"
    }

    suspend fun request2():String {
        delay(10000L)
        return "request1Response"
    }
}