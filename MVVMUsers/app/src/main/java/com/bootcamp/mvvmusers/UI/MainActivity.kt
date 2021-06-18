package com.bootcamp.mvvmusers.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bootcamp.mvvmusers.UI.viewModels.MainViewModel
import com.bootcamp.mvvmusers.UI.viewModels.MainViewModelStateEvent
import com.bootcamp.mvvmusers.databinding.ActivityMainBinding
import com.bootcamp.mvvmusers.model.User
import com.bootcamp.mvvmusers.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    private val mainViewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoad.setOnClickListener {
            mainViewModel.getUsers(MainViewModelStateEvent.GetUsersEvent)
            subscribeObservers()
        }
    }

    private fun subscribeObservers() {
        mainViewModel.usersDataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<User>> -> {
                    dataState.data.forEach { user ->
                        Log.d(TAG, user.name)
                    }
                }
                is DataState.Error -> {
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}