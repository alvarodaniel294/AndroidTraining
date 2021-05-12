package com.bootcamp.emptyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bootcamp.emptyapplication.Adapter.TeamAdapter
import com.bootcamp.emptyapplication.Interfaces.TeamListener
import com.bootcamp.emptyapplication.Models.Team
import com.bootcamp.emptyapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TeamListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listofTeams = Team.listofTeams()
        val recycler = binding.recycler
        val adapter = TeamAdapter(listofTeams,this)
        val layoutManager = LinearLayoutManager(this)

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }

    override fun onDeleteTeamTap(team: Team) {

    }

    override fun onViewTeamDetailTap() {

    }
}