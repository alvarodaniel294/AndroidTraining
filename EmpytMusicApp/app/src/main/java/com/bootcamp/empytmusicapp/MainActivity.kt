package com.bootcamp.empytmusicapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.data.IMusic
import com.bootcamp.empytmusicapp.data.MusicService
import com.bootcamp.empytmusicapp.data.adapter.MusicAdapter
import com.bootcamp.empytmusicapp.data.model.Music
import com.bootcamp.empytmusicapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),IMusic {

    lateinit var activityBinding: ActivityMainBinding
    lateinit var musicItemRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)
        initRecyclerView()
    }

    fun initRecyclerView(){
        musicItemRecycler = activityBinding.rvMusicItem
        val musicList = listOf<Music>(
            Music(1,"epic rap","09/05/2000", R.raw.epic_rap1),
            Music(2,"epic rap2","09/05/1980", R.raw.epic_rap1),
            Music(3,"epic rap3","09/05/1980", R.raw.epic_rap1),
        )
        musicItemRecycler.layoutManager = LinearLayoutManager(this)
        musicItemRecycler.adapter = MusicAdapter(musicList,this)
    }

    override fun didSelectCardView(music: Music) {
        val myIntent = Intent(this, MusicService::class.java)
        myIntent.putExtra(MusicService.SONG_EXTRA, music)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Toast.makeText(this,"hola musica",Toast.LENGTH_SHORT).show()
            startForegroundService(myIntent)
        }
    }

    override fun didStopButtonPressed() {
        val myIntent = Intent(this, MusicService::class.java)
        myIntent.putExtra(MusicService.STOP_EXTRA, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(myIntent)
        }
    }

    override fun didInfoButtonPressed() {
        //TODO: implementa la transicion de fragemento
    }

}