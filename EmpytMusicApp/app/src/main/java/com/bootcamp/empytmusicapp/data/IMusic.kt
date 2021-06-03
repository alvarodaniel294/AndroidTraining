package com.bootcamp.empytmusicapp.data

import com.bootcamp.empytmusicapp.data.model.Music

interface IMusic {
    fun didSelectCardView(music: Music)
    fun didStopButtonPressed()
    fun didInfoButtonPressed()
}