package com.bootcamp.musicapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.musicapp.databinding.ActivityMainBinding
import com.bootcamp.musicapp.models.Song
import com.bootcamp.musicapp.services.MusicService

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var song: Song

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        song = Song("skrillex", "reptile", R.raw.skrillex_reptile)

        binding.playBtn.setOnClickListener {
            playSong()
        }

        binding.stopBtn.setOnClickListener {
            stopSong()
        }

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

    fun onTapMusic(song: Song){

    }
}