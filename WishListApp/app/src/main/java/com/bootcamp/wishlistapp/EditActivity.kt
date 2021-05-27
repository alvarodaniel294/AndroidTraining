package com.bootcamp.wishlistapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import com.bootcamp.wishlistapp.databinding.ActivityEditBinding
import com.bootcamp.wishlistapp.databinding.ActivityMainBinding
import com.bootcamp.wishlistapp.entities.Wish
import com.bootcamp.wishlistapp.viewModels.MainViewModel

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    var wishId: Int? = null

    companion object {
        const val WISHID = "wishId"
        const val WISHTEXT = "wishText"
        const val WISHPRIORITY = "wishPriority"
        const val WISHOWNER = "wishOwner"
    }

    private lateinit var wishEditText: EditText
    private lateinit var priorityEditText: EditText
    private lateinit var ownerEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wishId = intent.getStringExtra(WISHID)?.toInt()
        binding.wishEditText.setText(intent.getStringExtra(WISHTEXT))
        binding.priorityEditText.setText(intent.getStringExtra(WISHPRIORITY))
        binding.ownerEditList.setText(intent.getStringExtra(WISHOWNER))

        wishEditText = binding.wishEditText
        priorityEditText = binding.priorityEditText
        ownerEditText = binding.ownerEditList

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
                val priorityText = priorityEditText.text.toString()
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