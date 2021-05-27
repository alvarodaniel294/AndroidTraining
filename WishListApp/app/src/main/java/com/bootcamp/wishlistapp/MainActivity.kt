package com.bootcamp.wishlistapp

import android.app.AlertDialog
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
import com.bootcamp.wishlistapp.listeners.WishListener
import com.bootcamp.wishlistapp.viewModels.MainViewModel

class MainActivity : AppCompatActivity(), WishListener {

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
            recycler.adapter = WishAdapter(it, this)
        })
    }

    private fun saveWish() {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setMessage("Are you sure you want to create the wish?")
            .setPositiveButton("Yes") { dialog, id ->
                val wishText = wishEditText.text.toString()
                val priorityText = priorityEditText.text.toString()
                val ownerText = ownerEditText.text.toString()
                val wishToSave = Wish(null, wishText, priorityText, ownerText)
                viewModel.saveWish(wishToSave, application)
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }

    override fun deleteWishItem(wish: Wish) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setMessage("Are you sure you want to delete the wish?")
            .setPositiveButton("Yes") { dialog, id ->
                viewModel.deleteWish(wish, application)
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }

    override fun editWishItem(wish: Wish) {
    }
}