package com.bootcamp.emptyapplication.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.emptyapplication.Interfaces.TeamListener
import com.bootcamp.emptyapplication.Models.Team
import com.bootcamp.emptyapplication.R
import com.squareup.picasso.Picasso

class TeamAdapter(val listOfTeams: MutableList<TeamAdapter>, val listener: TeamListener): RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.container_item, parent, false)
        val teamViewHolder: TeamViewHolder = TeamViewHolder(view)
        return teamViewHolder
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val item = listOfTeams[position]

    }

    private fun eliminarAnimal(team: Team) {
        listOfTeams.remove(team)
        this.notifyItemRemoved(listOfTeams.indexOf(team));
        this.notifyItemRangeChanged(listOfTeams.indexOf(team), listOfTeams.size);
    }

    override fun getItemCount(): Int {
        return listOfTeams.size
    }

    class TeamViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    }
}