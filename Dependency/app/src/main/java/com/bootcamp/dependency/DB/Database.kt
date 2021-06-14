package com.bootcamp.dependency.DB

import android.content.Context

class Database(context: Context, name:String) {

    object singleton{
        fun getInstance(context: Context): Database {
            return Database(context, "example")
        }
    }
}