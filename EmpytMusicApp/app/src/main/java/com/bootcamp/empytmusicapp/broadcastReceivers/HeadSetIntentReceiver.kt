package com.bootcamp.empytmusicapp.broadcastReceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.BatteryManager
import android.util.Log
import android.widget.Toast


class HeadSetIntentReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            if (it.action.equals(Intent.ACTION_HEADSET_PLUG)) {
                val isConnected = intent?.getIntExtra("state", -1)
                if (isConnected == 1){
                    Log.d("Headset Plugged", "Decrease Volumen")
                    val audioManager = context?.getSystemService(Context.AUDIO_SERVICE) as AudioManager
                    val volumeValue = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC) / 3
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volumeValue, 0)
                }
                if (isConnected == 0){
                    Log.d("Headset Unplugged", "Do nothing")
                }
            }
        }
    }
}