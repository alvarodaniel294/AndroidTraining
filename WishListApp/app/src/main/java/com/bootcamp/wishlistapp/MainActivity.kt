package com.bootcamp.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.bootcamp.wishlistapp.adapter.WishAdapter
import com.bootcamp.wishlistapp.databinding.ActivityMainBinding
import com.bootcamp.wishlistapp.db.WishDB
import com.bootcamp.wishlistapp.entities.Wish
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: WishAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = WishAdapter(getList(), this)

        binding.addButton.setOnClickListener {
            val text = binding.input.text.toString()
            val wish = Wish(null, text, "","")
            addWish(wish)
        }
    }

    fun getList() : List<Wish> {
        lifecycleScope.launch {
            val list = WishDB.getDatabase(this).wishDao().getWishList()
            lifecycleScope.
            return list
        }
    }

    fun addWish(wish: Wish) {
        WishDB.getDatabase(this).wishDao().addWish(wish)
    }
}