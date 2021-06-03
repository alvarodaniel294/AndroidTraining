package com.bootcamp.empytmusicapp.services

import android.app.*
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.bootcamp.empytmusicapp.MainActivity
import com.bootcamp.empytmusicapp.R
import com.bootcamp.empytmusicapp.models.Song

class MusicService: Service() {
    companion object {
        const val STOP_EXTRA = "STOP_EXTRA"
        const val SERVICE_ID = 3
        const val SONG_ID_EXTRA = "SONG_ID_EXTRA"
        const val SONG_EXTRA = "SONG_EXTRA"
    }

    private var songPlayer: MediaPlayer? = null


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val stop = intent?.getBooleanExtra(STOP_EXTRA, false) ?: false

        if (stop) {

            songPlayer?.release()
            songPlayer = null
            stopForeground(true)
        } else {
            val songId = intent?.getIntExtra(SONG_ID_EXTRA, -1)
            val song: Song? = intent?.getSerializableExtra(SONG_EXTRA) as Song?

            song?.let { song ->
                songPlayer?.let {

                } ?: kotlin.run {
                    songPlayer = MediaPlayer.create(baseContext, song.songResourceId)
                    songPlayer?.start()
                }
            }


            val pendingIntent = Intent(this, MainActivity::class.java).let {
                PendingIntent.getActivity(this, 0, it, 0)
            }

            registerChannel(this)

            val title = song?.title ?: "Bootcamp Mobile"
            val desc = song?.artist ?: "Second foreground service"

            val notification = NotificationCompat.Builder(this, "bootcamp")
                .setContentTitle(title)
                .setContentText(desc)
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