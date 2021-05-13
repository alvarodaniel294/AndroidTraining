package com.bootcamp.themeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_fromMaterial)



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)


        val button  = findViewById<Button>(R.id.gotodetail)
        button.setOnClickListener {
            startActivity(Intent(this, detailActivity::class.java))
        }
    }
}