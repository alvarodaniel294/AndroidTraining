package com.bootcamp.wishlistapp

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Spinner
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
    private lateinit var ownerEditText: EditText
    private lateinit var recycler: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var spinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wishEditText = binding.wishEditText
        spinner = binding.prioritySpinner
        ownerEditText = binding.ownerEditText

        progressBar = binding.progressBar

        binding.saveButton.setOnClickListener {
            saveWish()
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.priorities_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
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
                val priorityText = spinner.getSelectedItem().toString()
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
        val intent = Intent(this, EditActivity::class.java).apply {
            putExtra(EditActivity.WISHID, wish.id.toString())
            putExtra(EditActivity.WISHTEXT, wish.text)
            putExtra(EditActivity.WISHPRIORITY, wish.priority)
            putExtra(EditActivity.WISHOWNER, wish.owner)
        }
        startActivity(intent)
    }
}