package com.bootcamp.empytmusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.empytmusicapp.databinding.ActivitySongDetailBinding
import com.bootcamp.empytmusicapp.models.Song
import com.bootcamp.empytmusicapp.services.MusicService

class SongDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongDetailBinding
    private lateinit var song: Song
    companion object {
        const val SONG_EXTRA = "SONG_EXTRA"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        song = intent.getSerializableExtra(SONG_EXTRA) as Song
        binding.songImage.setImageResource(song.imageResourceId)
        binding.songName.text = song.name
        binding.songAuthor.text = getString(R.string.singleBy, song.author)
        binding.songReleaseYear.text = getString(R.string.releasedIn, song.releaseYear)
        binding.songAlbumName.text = getString(R.string.fromAlbum, song.album)
    }
}