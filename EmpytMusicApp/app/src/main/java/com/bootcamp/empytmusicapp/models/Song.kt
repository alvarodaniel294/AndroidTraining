package com.bootcamp.empytmusicapp.models

import com.bootcamp.empytmusicapp.R
import java.io.Serializable

data class Song( val title:String, val artist:String, val songResourceId:Int ): Serializable {

    companion object {
        fun listofSongs():MutableList<Song> {
            val mutableList = mutableListOf<Song>()

            mutableList.add(Song("t1","a1", R.raw.pf01 ))
            mutableList.add(Song("t2","a2", R.raw.pf02 ))
            mutableList.add(Song("t3","a3", R.raw.pf03 ))
            mutableList.add(Song("t4","a4", R.raw.pf04 ))

            return mutableList;
        }
    }
}