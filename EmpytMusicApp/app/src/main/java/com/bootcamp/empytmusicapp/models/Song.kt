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
            songList.add(Song("Peaches", "Justin Bieber", R.raw.justinbieber_peaches))
            songList.add(Song("Save your tears","The Weekend",  R.raw.theweekend_saveyourtears, ))
            songList.add(Song("Bad guy","Billie Eilish",  R.raw.billieeilish_badguy))
            songList.add(Song("Blinding lights","The Weekend",  R.raw.theweekend_blindinglights))
            return songList
        }
    }
}
