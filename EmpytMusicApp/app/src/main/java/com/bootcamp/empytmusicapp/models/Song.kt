package com.bootcamp.empytmusicapp.models

import com.bootcamp.empytmusicapp.R
import java.io.Serializable

data class Song(
    val name: String,
    val author: String,
    val songResourceId: Int
): Serializable {
    companion object {
        fun getSongList():MutableList<Song> {
            val songList = mutableListOf<Song>()
            songList.add(Song("Justin Bieber", "Peaches", R.raw.justinbieber_peaches))
            songList.add(Song("The Weekend", "Save your tears", R.raw.theweekend_saveyourtears))
            songList.add(Song("Billie Eilish", "Bad guy", R.raw.billieeilish_badguy))
            songList.add(Song("The Weekend", "Blinding lights", R.raw.theweekend_blindinglights))
            return songList
        }
    }
}