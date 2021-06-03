package com.bootcamp.empytmusicapp.models

data class Song(
    val songName: String,
    val songAuthor: String
) {
    companion object {
        fun getSongList():MutableList<Song> {
            val songList = mutableListOf<Song>()
            songList.add(Song("", ""))
            return songList
        }
    }
}
