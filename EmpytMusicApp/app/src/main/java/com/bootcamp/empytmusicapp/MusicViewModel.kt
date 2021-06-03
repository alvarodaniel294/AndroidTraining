package com.bootcamp.empytmusicapp

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bootcamp.empytmusicapp.models.Song

class MusicViewModel(): ViewModel() {

    var songList: List<Song> = generateList()

    private fun generateList(): List<Song> {
        val list = mutableListOf<Song>()
        list.add(Song("DropsOfJupiter","Train", R.raw.dropsofjupiter))
        list.add(Song("Fix You","Coldplay", R.raw.fixyou))
        return list
    }
}