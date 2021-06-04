package com.bootcamp.empytmusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.empytmusicapp.databinding.ActivitySongDetailBinding

class SongDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongDetailBinding
    companion object {
        const val SONG_EXTRA = "SONG_EXTRA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.songName
    }
}