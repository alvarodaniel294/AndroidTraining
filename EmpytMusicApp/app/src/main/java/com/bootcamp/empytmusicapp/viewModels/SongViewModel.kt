package com.bootcamp.empytmusicapp.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bootcamp.empytmusicapp.models.Song

class SongViewModel: ViewModel() {
    private val _song: MutableLiveData<Song> = MutableLiveData()
    val song: LiveData<Song> = _song

    fun changeSong(song: Song) {
        _song.value = song
    }
}