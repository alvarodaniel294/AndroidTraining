package com.bootcamp.broadcastapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast

class BatteryConnectionReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val isConnected = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) ?: return

        if (isConnected == 0){
            Toast.makeText(context, "battery not connected", Toast.LENGTH_LONG).show()

        }
        if (isConnected == 1){
            Toast.makeText(context, "battery connected", Toast.LENGTH_LONG).show()

        }
    }
}