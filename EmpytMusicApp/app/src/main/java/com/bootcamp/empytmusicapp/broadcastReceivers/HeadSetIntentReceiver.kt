package com.bootcamp.empytmusicapp.broadcastReceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


class HeadSetIntentReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("Headset", "Init")
        intent?.let {
            if (it.action.equals(Intent.ACTION_HEADSET_PLUG)) {
                //val audioManager = context?.getSystemService(Context.AUDIO_SERVICE)
                Log.d("Headset", "Connected")
            }
        }
    }
}