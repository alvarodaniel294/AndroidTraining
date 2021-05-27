package com.bootcamp.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.wishlistapp.adapters.WishAdapter
import com.bootcamp.wishlistapp.databinding.ActivityMainBinding
import com.bootcamp.wishlistapp.entities.Wish
import com.bootcamp.wishlistapp.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var wishEditText: EditText
    private lateinit var priorityEditText: EditText
    private lateinit var ownerEditText: EditText
    private lateinit var recycler: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wishEditText = binding.wishEditText
        priorityEditText = binding.priorityEditText
        ownerEditText = binding.ownerEditList

        progressBar = binding.progressBar

        binding.saveButton.setOnClickListener {
            saveWish()
        }

        recycler = binding.recyclerList
        recycler.layoutManager = LinearLayoutManager(this)

        viewModel.getListFromDatabase(application).observe(this, {
            recycler.adapter = WishAdapter(it)
        })
    }

    private fun saveWish() {
        val wishText = wishEditText.text.toString()
        val priorityText = priorityEditText.text.toString()
        val ownerText = ownerEditText.text.toString()
        val wishToSave = Wish(null, wishText, priorityText, ownerText)
        viewModel.saveWish(wishToSave, application)
    }
}