package com.bootcamp.mvvmusers.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.mvvmusers.R
import com.bootcamp.mvvmusers.databinding.ActivityMainBinding
import com.bootcamp.mvvmusers.ui.adapter.UserAdapter
import com.bootcamp.mvvmusers.ui.viewmodel.VieModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: VieModel
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = VieModel()
        recycler = binding.list
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.btnLoad.setOnClickListener {
            viewModel.getUsers()
        }

        viewModel.users.observe(this, { users ->
            val adapter = UserAdapter(users)
            recycler.adapter = adapter
        })
    }
}