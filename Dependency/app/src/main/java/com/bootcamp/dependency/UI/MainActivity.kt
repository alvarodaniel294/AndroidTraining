package com.bootcamp.dependency.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bootcamp.dependency.R
import com.bootcamp.dependency.UI.viewmodels.MainViewModel
import com.bootcamp.dependency.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel:MainViewModel by viewModels()

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