package com.bootcamp.empytmusicapp

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.adapters.SongAdapter
import com.bootcamp.empytmusicapp.broadcastReceivers.HeadSetIntentReceiver
import com.bootcamp.empytmusicapp.databinding.ActivityMainBinding
import com.bootcamp.empytmusicapp.listeners.SongListener
import com.bootcamp.empytmusicapp.models.Song
import com.bootcamp.empytmusicapp.services.MusicService
import com.bootcamp.empytmusicapp.viewModels.SongViewModel

class MainActivity : AppCompatActivity(), SongListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    lateinit var songList: MutableList<Song>
    private val viewModel: SongViewModel by viewModels()
    private lateinit var headSetIntentReceiver : HeadSetIntentReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        headSetIntentReceiver = HeadSetIntentReceiver()
        IntentFilter(Intent.ACTION_HEADSET_PLUG).also {
            registerReceiver(headSetIntentReceiver, it)
        }
        songList = Song.getSongList()
        recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SongAdapter(songList, this)
    }

    override fun playSong(song: Song) {
        val intent = Intent(this, MusicService::class.java)
        intent.putExtra(MusicService.SONG_EXTRA, song)
        viewModel.changeSong(song)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
        }
    }

    override fun viewSongDetail(song: Song) {
        val intent = Intent(this, SongDetailActivity::class.java).apply {
            putExtra(SongDetailActivity.SONG_EXTRA, song)
        }
        startActivity(intent)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(headSetIntentReceiver)
    }
}