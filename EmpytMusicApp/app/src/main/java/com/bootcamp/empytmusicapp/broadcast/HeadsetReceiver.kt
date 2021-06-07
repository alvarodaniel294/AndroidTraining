package com.bootcamp.empytmusicapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HeadsetReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isHeadset = intent?.getBooleanExtra("state", false) ?: return
        val audioManager = context?.getSystemService(AppCompatActivity.AUDIO_SERVICE) as AudioManager
        if (isHeadset){
            Toast.makeText(context, "HEADSET IS CONNECTED", Toast.LENGTH_LONG).show()
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);
        }
        else{
            Toast.makeText(context, "HEADSET IS DISCONNECTED", Toast.LENGTH_LONG).show()
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 5, 0);
        }
    }
}