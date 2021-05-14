package com.bootcamp.emptyapplication.models

import java.io.Serializable

data class Item(
    var title: String,
    var imageUrl: String
) : Serializable

