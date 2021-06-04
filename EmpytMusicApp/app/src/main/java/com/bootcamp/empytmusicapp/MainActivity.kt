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
    companion object{
        const val SONG_ID = "SONG_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)
        initRecyclerView()
    }

    fun initRecyclerView(){
        musicItemRecycler = activityBinding.rvMusicItem
        musicItemRecycler.layoutManager = LinearLayoutManager(this)
        musicItemRecycler.adapter = MusicAdapter(Music.musicList,this)
    }

    override fun didSelectCardView(music: Music) {
        val myIntent = Intent(this, MusicService::class.java)
        myIntent.putExtra(MusicService.SONG_EXTRA, music)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Toast.makeText(this,"musica: ${music.nombre}",Toast.LENGTH_SHORT).show()
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

    override fun didInfoButtonPressed(music: Music) {
        Toast.makeText(this,"hola dato fue presionado",Toast.LENGTH_SHORT).show()
        val myBundle = Bundle()
        myBundle.putString(SONG_ID,music.id.toString())
        val intent = Intent(this,MainActivity2::class.java)
    }

}