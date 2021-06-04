package com.bootcamp.empytmusicapp.listener

import com.bootcamp.empytmusicapp.models.Song

interface SongListener {
    fun onClickToPlay(song: Song);
}