package com.bootcamp.emptyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.emptyapplication.databinding.ActivityDetailsBinding
import com.bootcamp.emptyapplication.databinding.ActivityMainBinding
import com.bootcamp.emptyapplication.models.Item
import com.squareup.picasso.Picasso

class Details : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = intent.getSerializableExtra("item") as Item
        binding.detailsTextView.text = item.title
        Picasso.get().load(item.imageUrl).into(binding.detailsImageView)
    }
}