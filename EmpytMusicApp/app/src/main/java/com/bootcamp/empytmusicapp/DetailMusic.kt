package com.bootcamp.empytmusicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailMusic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_music)

        val message = intent.getStringExtra("DETAIL")

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }
}