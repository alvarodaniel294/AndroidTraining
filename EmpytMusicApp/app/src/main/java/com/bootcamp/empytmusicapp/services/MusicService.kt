package com.bootcamp.empytmusicapp.services

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.bootcamp.empytmusicapp.MainActivity
import com.bootcamp.empytmusicapp.R

class MusicService: Service() {
    companion object {
        const val STOP_FLAG = "STOP_FLAG"
        const val SERVICE_ID = 3
    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val stop = intent?.getBooleanExtra(STOP_FLAG, false) ?: false
        if (stop) {
            stopForeground(true)
        } else {
            val pendingIntent = Intent(this, MainActivity::class.java).let {
                PendingIntent.getActivity(this, 0, it, 0)
            }
            registerChannel(this)
            val notification = NotificationCompat.Builder(this, "musicapp")
                .setContentTitle("Music")
                .setContentText("Music App")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .build()
            startForeground(SERVICE_ID, notification)
        }
        return START_STICKY
    }
    private fun registerChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("musicapp", "musicapp", NotificationManager.IMPORTANCE_LOW)
            channel.description = "Description"
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}