package com.bootcamp.mvvmusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bootcamp.mvvmusers.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var userViewModel = UserViewModel()
    var app = applicationContext as MvvmUsersApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonListener()
    }

    fun initButtonListener(){
        binding.btnLoad.setOnClickListener {
            userViewModel.getUsers(this)
            userViewModel.users.value?.let { it1 -> app.room.userDao().insertAll(it1) }
        }
    }


}