package com.bootcamp.dependency.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bootcamp.dependency.R
import com.bootcamp.dependency.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val asdf = "asdf"

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav = binding.bottomNav
        val navController = findNavController(R.id.nav_controller_container)


        bottomNav.setupWithNavController(navController)
    }

    fun saveInDatabase(){
//        val database = Database.singleton.getInstance(this)


    }
}