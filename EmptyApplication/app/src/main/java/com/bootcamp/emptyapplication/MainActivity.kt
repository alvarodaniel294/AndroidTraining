package com.bootcamp.emptyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.emptyapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var dogs = mutableListOf<String>(
        "https://images.dog.ceo/breeds/hound-basset/n02088238_9626.jpg",
            "https://images.dog.ceo/breeds/mexicanhairless/n02113978_2425.jpg",
            "https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_4028.jpg",
            "https://images.dog.ceo/breeds/hound-basset/n02088238_9626.jpg",
            "https://images.dog.ceo/breeds/mexicanhairless/n02113978_2425.jpg",
            "https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_4028.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // seteando el vavbar
        val bottomNav = binding.mainBottomNavigation
        val navController = findNavController(R.id.fragment)
        bottomNav.setupWithNavController(navController)
        // iniciando mi recyclerView
        initRecycler()
    }

    fun initRecycler(){
        val rv_RecycleView: RecyclerView = findViewById(R.id.rv_dogs)
        rv_RecycleView.layoutManager = LinearLayoutManager(this) //HomeFragment().context
        val recyclerAdapter = DogAdapter(dogs)
        rv_RecycleView.adapter = recyclerAdapter
    }
}