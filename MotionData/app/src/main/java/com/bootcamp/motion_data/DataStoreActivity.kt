package com.bootcamp.motion_data

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.bootcamp.motion_data.databinding.ActivityDataStoreBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataStoreActivity : AppCompatActivity() {

    lateinit var userPreferences: UserPreferences
    private lateinit var binding: ActivityDataStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userPreferences = UserPreferences(this)

        binding.buttonSave.setOnClickListener {
            val nameToSave = binding.editTextTextPersonName.text.toString()
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    userPreferences.saveName(nameToSave)
                }
            }
        }


        userPreferences.name.asLiveData().observe(this, Observer {
            binding.nameTextView.text = it ?: ""
        })

    }


}