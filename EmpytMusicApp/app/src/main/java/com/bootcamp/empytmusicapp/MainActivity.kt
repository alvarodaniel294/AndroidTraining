package com.bootcamp.empytmusicapp

import android.content.Intent
import android.media.AudioManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.adapter.MusicAdapter
import com.bootcamp.empytmusicapp.databinding.ActivityMainBinding
import com.bootcamp.empytmusicapp.models.Song
import com.bootcamp.empytmusicapp.services.MusicService

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var  song: Song

    lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recycler = binding.musicRecycler
//        song = Song("reptile", "skrillex", R.raw.skrillex_reptile)
//        song = Song("The Nights", "Avicii", R.raw.avicii_thenights)
        song = Song("Wake me up", "Avicii", R.raw.avicii_wakeneup)


        binding.playBtn.setOnClickListener{
            playSong()
        }
        binding.stopBtn.setOnClickListener {
            stopSong()
        }


        val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager
        binding.btnUp.setOnClickListener {
            audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND)
        }
        binding.btnDown.setOnClickListener {
            audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND)
        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter = MusicAdapter(mutableListOf(), application)
    }
    private fun stopSong(){
        val intentF = Intent(this, MusicService::class.java)
        intentF.putExtra(MusicService.STOP_EXTRA, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            startForegroundService(intentF)
        }

    }
    private fun playSong(){
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