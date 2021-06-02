package com.bootcamp.broadcastapp.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService:Service() {


    val TAG = "MyService"
    init {
        Log.d(TAG, "service started")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val value = intent?.getStringExtra("SERVICE_EXTRA") ?: ""
        Log.d(TAG, value)

        return Service.START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "service stopped")
    }
}