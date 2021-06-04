package com.bootcamp.empytmusicapp.data

import android.app.*
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.bootcamp.empytmusicapp.MainActivity
import com.bootcamp.empytmusicapp.R
import com.bootcamp.empytmusicapp.data.model.Music

class MusicService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    companion object{
        const val STOP_EXTRA = "STOP_EXTRA"
        const val SERVICE_ID = 3
        const val SONG_EXTRA = "SONG_EXTRA"
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val stop = intent?.getBooleanExtra(STOP_EXTRA, false) ?: false
        if (stop) {
            stopMyMusic()
        } else {
            val song: Music? = intent?.getSerializableExtra(SONG_EXTRA) as Music?
            if(mediaPlayer != null){
                stopMyMusic()
            }
            song?.let { song ->
                mediaPlayer?.let {
                } ?: kotlin.run {
                    mediaPlayer = MediaPlayer.create(baseContext, song.srcMusic)
                    mediaPlayer?.start()
                }
            }
            val pendingIntent = Intent(this, MainActivity::class.java).let {
                PendingIntent.getActivity(this, 0, it, 0)
            }
            registerChannel(this)
            val title = song?.nombre ?: "Bootcamp Mobile"
            val desc = song?.date ?: "Second foreground service"
            val notification = NotificationCompat.Builder(this, "bootcamp")
                .setContentTitle(title)
                .setContentText(desc)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(R.drawable.ic_stop_circle)
                .setContentIntent(pendingIntent)
                .build()
            startForeground(SERVICE_ID, notification)
        }
        return START_STICKY
    }

    fun stopMyMusic(){
        mediaPlayer?.release()
        mediaPlayer = null
        stopForeground(true)
    }

    private fun registerChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("bootcamp", "bootcamp", NotificationManager.IMPORTANCE_LOW)
            channel.description = "asdf"
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


}