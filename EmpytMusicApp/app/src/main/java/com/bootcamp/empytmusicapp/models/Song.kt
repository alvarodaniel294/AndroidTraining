package com.bootcamp.empytmusicapp.models

import com.bootcamp.empytmusicapp.R
import java.io.Serializable

data class Song(
    val name: String,
    val author: String,
    val songResourceId: Int,
    val releaseYear: String,
    val album: String,
    var imageResourceId: Int
): Serializable {
    companion object {
        fun getSongList():MutableList<Song> {
            val songList = mutableListOf<Song>()
            songList.add(Song("Peaches", "Justin Bieber", R.raw.justinbieber_peaches, "2021", "Justice", R.drawable.peaches))
            songList.add(Song("Willow", "Taylor Swift", R.raw.taylorswift_willow, "2020", "Evermore", R.drawable.willow))
            songList.add(Song("Save your tears","The Weekend",  R.raw.theweekend_saveyourtears, "2020", "After Hours", R.drawable.saveyourtears ))
            songList.add(Song("Bad guy","Billie Eilish",  R.raw.billieeilish_badguy,"2019", "When We All Fall Sleep", R.drawable.badguy))
            songList.add(Song("Blinding lights","The Weekend",  R.raw.theweekend_blindinglights, "2020", "After Hours", R.drawable.blindinglights))
            songList.add(Song("Afterglow", "Taylor Swift", R.raw.taylorswift_afterglow, "2019", "Lover", R.drawable.afterglow))
            return songList
        }
    }
}
