package com.bootcamp.empytmusicapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.adapters.SongAdapter
import com.bootcamp.empytmusicapp.databinding.ActivityMainBinding
import com.bootcamp.empytmusicapp.listeners.SongListener
import com.bootcamp.empytmusicapp.models.Song
import com.bootcamp.empytmusicapp.services.MusicService

class MainActivity : AppCompatActivity(), SongListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    lateinit var songList: MutableList<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        songList = Song.getSongList()
        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SongAdapter(songList, this)
    }

    override fun playSong(song: Song) {
        val intent = Intent(this, MusicService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
        }
    }

    override fun stopSong(song: Song) {
        val intent = Intent(this, MusicService::class.java)
        intent.putExtra(MusicService.STOP_FLAG, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
        }
    }

    override fun viewSongDetail(song: Song) {
    }
}