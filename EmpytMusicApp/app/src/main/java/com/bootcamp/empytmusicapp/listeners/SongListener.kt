package com.bootcamp.empytmusicapp.listeners

import com.bootcamp.empytmusicapp.models.Song

interface SongListener {
    fun play(song: Song)
}