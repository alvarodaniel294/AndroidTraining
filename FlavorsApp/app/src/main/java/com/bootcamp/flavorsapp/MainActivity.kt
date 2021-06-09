package com.bootcamp.flavorsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.textMainActivity)
        val text2 = findViewById<TextView>(R.id.text2MainActivity)

//        BuildConfig.
        text.text = "this application is ${getString(R.string.res_value_from_build)}"

        val flavor = BuildConfig.FLAVOR
        text2.text = "our flavor is $flavor  ${BuildConfig.OUR_STRING}"




    }
}