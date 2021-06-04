package com.bootcamp.empytmusicapp.data.model

import com.bootcamp.empytmusicapp.R
import java.io.Serializable

data class Music(
    val id: Int,
    val nombre: String,
    val date: String,
    val srcMusic: Int
): Serializable{
    companion object {
        val musicList = listOf<Music>(
            Music(1,"epic rap","09/05/2000", R.raw.epic_rap1),
            Music(2,"epic rap2","09/05/1980", R.raw.epic_philosopher)
        )
    }
}