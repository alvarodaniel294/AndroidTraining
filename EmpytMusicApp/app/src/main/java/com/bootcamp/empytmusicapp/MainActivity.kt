package com.bootcamp.empytmusicapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.empytmusicapp.adapter.SongAdapter
import com.bootcamp.empytmusicapp.databinding.ActivityMainBinding
import com.bootcamp.empytmusicapp.listener.SongListener
import com.bootcamp.empytmusicapp.models.Song
import com.bootcamp.empytmusicapp.services.MusicService
import java.util.*


class MainActivity : AppCompatActivity(), SongListener {

    lateinit var binding: ActivityMainBinding
    lateinit var song: Song

    private var audioManager: AudioManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = SongAdapter((Song.listofSongs()), this)

        binding.playBtn.setOnClickListener {
            playSong()
        }

        binding.stopBtn.setOnClickListener {
            stopSong()
        }
        initSeekbar()

        val receiverFilter = IntentFilter(Intent.ACTION_HEADSET_PLUG)
        val receiver = HeadSetReceiver()
        registerReceiver(receiver, receiverFilter)
    }

    private fun stopSong() {
        val intentF = Intent(this, MusicService::class.java)
        intentF.putExtra(MusicService.STOP_EXTRA, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intentF)
        }
    }

    private fun playSong() {

        val intentF = Intent(this, MusicService::class.java)
        intentF.putExtra(MusicService.SONG_ID_EXTRA, song.songResourceId)
        intentF.putExtra(MusicService.SONG_EXTRA, song)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intentF)
        }
    }

    override fun onClickToPlay(song: Song) {
        stopSong()
        this.song = song
        playSong()
        Log.d("MAIN",song.artist)
    }

    override fun onClickToWatchDetail(song: Song) {
        val intent = Intent(this, DetailMusic::class.java).apply {
            putExtra("DETAIL", "song.artist")
        }
        startActivity(intent)
    }

    private fun initSeekbar() {
        try {
            audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
            binding.seekBarMusic.setMax(
                audioManager!!
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            )
            binding.seekBarMusic.setProgress(
                audioManager!!
                    .getStreamVolume(AudioManager.STREAM_MUSIC)
            )
            binding.seekBarMusic.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onStopTrackingTouch(arg0: SeekBar) {}
                override fun onStartTrackingTouch(arg0: SeekBar) {}
                override fun onProgressChanged(arg0: SeekBar, progress: Int, arg2: Boolean) {
                    audioManager!!.setStreamVolume(
                        AudioManager.STREAM_MUSIC,
                        progress, 0
                    )
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

private class HeadSetReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_HEADSET_PLUG) {
            val state = intent.getIntExtra("state", -1)
            when (state) {
                0 -> {
                    Log.d("HEADSET", "Headset unplugged")
                }
                1 -> {
                    Log.d("HEADSET", "Headset plugged")
                }
            }
        }
    }
}