package com.bootcamp.broadcastapp.services

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.bootcamp.broadcastapp.MainActivity
import com.bootcamp.broadcastapp.R

class MyForegroundService: Service() {

    companion object {
        const val SERVICE_ID = 3
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val stop = intent?.getBooleanExtra("STOP_EXTRA", false) ?: false
        if (stop){
            stopForeground(true)
        }else{

            val pendingIntent =Intent(this, MainActivity::class.java).let {
                PendingIntent.getActivity(this, 0, it, 0)
            }

            registerChannel(this)

            val notification = NotificationCompat.Builder(this , "bootcamp")
                .setContentTitle("Bootcamp Mobile")
                .setContentText("Firs foreground service")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .build()



            startForeground( SERVICE_ID, notification)
        }



        return START_STICKY
    }

    private fun registerChannel(context: Context){
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel  = NotificationChannel("bootcamp", "bootcamp", NotificationManager.IMPORTANCE_LOW)
            channel.description = "asdf"
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}