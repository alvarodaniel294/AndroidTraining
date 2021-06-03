package com.bootcamp.empytmusicapp.models

import java.io.Serializable

data class Song(
    val title: String,
    val artist: String,
    val srcId: Int
): Serializable
