package com.bootcamp.empytmusicapp.listeners

import com.bootcamp.empytmusicapp.models.Song

interface SongListener {
    fun playSong(song: Song)
    fun stopSong(song: Song)
    fun viewSongDetail(song: Song)
}