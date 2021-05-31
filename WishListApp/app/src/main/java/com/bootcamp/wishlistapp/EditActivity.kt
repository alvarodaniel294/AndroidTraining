package com.bootcamp.wishlistapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.viewModels
import com.bootcamp.wishlistapp.databinding.ActivityEditBinding
import com.bootcamp.wishlistapp.entities.Wish
import com.bootcamp.wishlistapp.viewModels.MainViewModel

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private var wishId: Int? = null

    companion object {
        const val WISHID = "wishId"
        const val WISHTEXT = "wishText"
        const val WISHPRIORITY = "wishPriority"
        const val WISHOWNER = "wishOwner"
    }

    private lateinit var wishEditText: EditText
    private lateinit var spinner: Spinner
    private lateinit var ownerEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wishId = intent.getStringExtra(WISHID)?.toInt()
        binding.wishEditText.setText(intent.getStringExtra(WISHTEXT))
        binding.ownerEditText.setText(intent.getStringExtra(WISHOWNER))

        wishEditText = binding.wishEditText
        spinner = binding.prioritySpinner
        ownerEditText = binding.ownerEditText

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

        binding.editButton.setOnClickListener {
            editWish()
        }
    }

    private val viewModel: MainViewModel by viewModels()

    private fun editWish() {
        val builder = AlertDialog.Builder(this@EditActivity)
        builder.setMessage("Are you sure you want to edit the wish?")
            .setPositiveButton("Yes") { dialog, id ->
                val wishText = wishEditText.text.toString()
                val priorityText = spinner.getSelectedItem().toString()
                val ownerText = ownerEditText.text.toString()
                val wishToSave = Wish(wishId, wishText, priorityText, ownerText)
                viewModel.saveWish(wishToSave, application)
                finish()
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }
}