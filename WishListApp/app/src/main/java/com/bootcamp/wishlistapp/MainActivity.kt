package com.bootcamp.wishlistapp

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.wishlistapp.databinding.ActivityMainBinding
import com.bootcamp.wishlistapp.listener.WishListener
import com.bootcamp.wishlistapp.viewmodelFactory.WishViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), WishListener {

    private lateinit var binding: ActivityMainBinding

    val viewModel: WishViewModel by viewModels<WishViewModel> {
        WishViewModelFactory((application as WishApp).wishRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wishRecycler.layoutManager = LinearLayoutManager(this)
        binding.wishRecycler.setHasFixedSize(true)
        binding.wishRecycler.adapter = WishAdapter(mutableListOf(), this)

        binding.btnAgregarDeseo.setOnClickListener {
            this.showPopUp()
        }

        viewModel.wishList.observe(this, Observer {
            binding.wishRecycler.adapter = WishAdapter(it,this)
        })
    }

    private fun showPopUp() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.popupwish, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.wishText)

        with(builder) {
            setTitle("Add your Wish")
            setPositiveButton("OK") { dialog, whitch ->
                saveInDBWithRepository(editText.text.toString())
            }
            setView(dialogLayout)
            show()
        }
    }

    private fun saveInDBWithRepository(wish: String){
        val record = Wish(null,wish, "important", "Cristian")
        viewModel.saveDataWithRepository(record)
    }

    override fun onRemoveItem(wish: Wish) {

        val dialogClickListener =
            DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        CoroutineScope(Dispatchers.IO).launch {
                            viewModel.deleteWish(wish)
                            Log.d("ELIMINAR",wish.id.toString())
                        }
                    }
                    DialogInterface.BUTTON_NEGATIVE -> {

                    }
                }
            }

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
            .setNegativeButton("No", dialogClickListener).show()
    }

    override fun onEditItem(wish: Wish) {
        Log.d("EDITAR",wish.id.toString())
    }
}