package com.bootcamp.broadcastapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneReceiver:BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        val isInAirplaneMode = intent?.getBooleanExtra("state", false) ?: return

        if (isInAirplaneMode){
            Toast.makeText(context, "Airplane active", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Airplane inactive", Toast.LENGTH_LONG).show()

        }
    }
}