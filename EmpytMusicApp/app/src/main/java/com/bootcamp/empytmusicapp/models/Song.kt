package com.bootcamp.empytmusicapp.models

data class Song(
    val name: String,
    val author: String
) {
    companion object {
        fun getSongList():MutableList<Song> {
            val songList = mutableListOf<Song>()
            songList.add(Song("hola", "yes"))
            songList.add(Song("hola2", "yeah"))
            return songList
        }
    }
}
