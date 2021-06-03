package com.bootcamp.empytmusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SongDetailActivity : AppCompatActivity() {
    companion object {
        const val SONG_EXTRA = "SONG_EXTRA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_detail)
    }
}