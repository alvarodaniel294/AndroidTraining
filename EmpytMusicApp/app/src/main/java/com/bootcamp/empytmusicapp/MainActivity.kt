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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.adapters.SongAdapter
import com.bootcamp.empytmusicapp.databinding.ActivityMainBinding
import com.bootcamp.empytmusicapp.listeners.SongListener
import com.bootcamp.empytmusicapp.models.Song
import com.bootcamp.empytmusicapp.receivers.HeadsetReceiver
import com.bootcamp.empytmusicapp.services.MusicService


class MainActivity : AppCompatActivity(), SongListener {

    lateinit var binding: ActivityMainBinding
    private lateinit var recycler: RecyclerView
    private lateinit var viewModel: MusicViewModel
    private lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = MusicViewModel()

        recycler = binding.list
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter = SongAdapter(viewModel.songList, this)

        binding.stopButton.setOnClickListener {
            stop()
        }

        val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        binding.seekBar2.max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        binding.seekBar2.progress = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        binding.seekBar2.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        HeadsetReceiver.instance.register(this)
        HeadsetReceiver.instance.callback = object : HeadsetReceiver.HeadsetReceiverCallback {
            override fun onHeadsetConnected() {
                Log.d("HEADPHONES","connected!")
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0)
            }
            override fun onHeadsetDisconnected() {
                Log.d("HEADPHONES","disconnected!")
            }
        }
    }

    override fun play(song: Song) {
        binding.textView.text = song.title
        binding.textView2.text = song.artist
        val intentF = Intent(this, MusicService::class.java)
        intentF.putExtra(MusicService.SONG_ID_EXTRA, song.srcId)
        intentF.putExtra(MusicService.SONG_EXTRA, song)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intentF)
        }
    }

    private fun stop() {
        binding.textView.text = ""
        binding.textView2.text = ""
        val intentF = Intent(this, MusicService::class.java)
        intentF.putExtra(MusicService.STOP_EXTRA, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intentF)
        }
    }


    override fun onPause() {
        HeadsetReceiver.instance.unregister(this)
        super.onPause()
    }
}