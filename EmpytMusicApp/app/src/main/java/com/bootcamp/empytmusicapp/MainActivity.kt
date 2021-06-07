package com.bootcamp.empytmusicapp

import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.adapter.MusicAdapter
import com.bootcamp.empytmusicapp.broadcast.HeadsetReceiver
import com.bootcamp.empytmusicapp.databinding.ActivityMainBinding
import com.bootcamp.empytmusicapp.models.ListItemClickListener
import com.bootcamp.empytmusicapp.models.Song
import com.bootcamp.empytmusicapp.services.MusicService
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity(), ListItemClickListener {
    lateinit var headsetReceiver: HeadsetReceiver
    lateinit var binding: ActivityMainBinding
    var  song = listOf<Song>(
        Song("reptile", "skrillex", R.raw.skrillex_reptile),
//        Song("The Nights", "Avicii", R.raw.Avicii_TheNights),
        Song("Wake me up", "Avicii", R.raw.avicii_wakeneup)  ,
    )

    lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recycler = binding.musicRecycler



        binding.playBtn.setOnClickListener{
            playSong()
        }
        binding.stopBtn.setOnClickListener {
            stopSong()
        }

        binding.sliderVolume.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {

                // Responds to when slider's touch event is being started
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being stopped
            }
        })
        val audioManager = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager
        binding.sliderVolume.addOnChangeListener { rangeSlider, value, fromUser ->
            val currentVolume: Int = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
            val maxVolume: Int = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            val percent = value
            val seventyVolume = (maxVolume * percent).toInt()
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, seventyVolume, 0)
        }

        
        binding.btnUp.setOnClickListener {
            audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND)

        }
        binding.btnDown.setOnClickListener {
            audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND,)

        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)

        recycler.adapter = MusicAdapter(song, this)


        //BROADCAST
        headsetReceiver = HeadsetReceiver()

        IntentFilter(Intent.ACTION_HEADSET_PLUG). also {
            registerReceiver(HeadsetReceiver(), it)
        }
    }
    override  fun onStop(){
        super.onStop()
        unregisterReceiver(headsetReceiver)
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
        intentF.putExtra(MusicService.SONG_ID_EXTRA, song[0].songResourceId)
        intentF.putExtra(MusicService.SONG_EXTRA, song[0])
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intentF)
        }
    }
    override fun onListItemClick(song: Song) {
        binding.musicTitle.text = song.title
        binding.musicArtist.text = song.artist
        val intentF = Intent(this, MusicService::class.java)
        intentF.putExtra(MusicService.SONG_ID_EXTRA, song.songResourceId)
        intentF.putExtra(MusicService.SONG_EXTRA, song)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intentF)
        }
    }

}