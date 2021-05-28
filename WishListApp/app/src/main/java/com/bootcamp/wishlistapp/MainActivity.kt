package com.bootcamp.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.wishlistapp.adapter.WishAdapter
import com.bootcamp.wishlistapp.databinding.ActivityMainBinding
import com.bootcamp.wishlistapp.databinding.EditDialogBinding
import com.bootcamp.wishlistapp.entities.Wish
import com.bootcamp.wishlistapp.interfaces.WishListListener
import com.bootcamp.wishlistapp.viewmodelFactory.WishViewModelFactory

class MainActivity : AppCompatActivity(), WishListListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recycler: RecyclerView
    private val viewModel: WishViewModel by viewModels {
        WishViewModelFactory((application as WishApp).wishRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recycler = binding.list
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter = WishAdapter(mutableListOf(), this)

        viewModel.wishList.observe( this, {
            recycler.adapter = WishAdapter(it, this)
        })

        binding.addButton.setOnClickListener {
            saveInDB()
        }
    }


    private fun saveInDB(){
        val text = binding.textInput.text.toString()
        val owner = binding.ownerInput.text.toString()
        val priority = binding.priorityInput.text.toString()
        if (text != "" && owner != "" && priority != "" ) {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setMessage("Do you want to add wish with name: $text")
                .setCancelable(false)
                .setPositiveButton("Yes") { _, id ->
                    val wish = Wish(null, text, priority, owner)
                    viewModel.saveWish(wish)
                    binding.textInput.text?.clear()
                    binding.ownerInput.text?.clear()
                    binding.priorityInput.text?.clear()
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }
    }

    override fun didEditPressed(wish: Wish) {
        val builder = AlertDialog.Builder(this@MainActivity)
        val dialogBinding = EditDialogBinding.inflate(layoutInflater)
        val editText = dialogBinding.textInput
        val editOwner = dialogBinding.ownerInput
        val editPriority = dialogBinding.priorityInput
        editText.text?.append(wish.text)
        editOwner.text?.append(wish.owner)
        editPriority.text?.append(wish.priority)

        with(builder) {
            setTitle("Edit Wish")
            setPositiveButton("Save") { dialog, which ->
                wish.text = editText.text.toString()
                wish.owner = editOwner.text.toString()
                wish.priority = editPriority.text.toString()
                viewModel.editWish(wish)
                recycler.adapter?.notifyDataSetChanged()
                editText.text?.clear()
                editOwner.text?.clear()
                editPriority.text?.clear()

            }
            setNegativeButton("Cancel") {dialog, which ->
                dialog.dismiss()
                editText.text?.clear()
                editOwner.text?.clear()
                editPriority.text?.clear()
            }
            setView(dialogBinding.root)
            show()
        }
    }

    override fun didRemovePressed(wish: Wish) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setMessage("Are you sure you want to delete?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, id ->
                viewModel.removeWish(wish)
                recycler.adapter?.notifyDataSetChanged()
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }
}