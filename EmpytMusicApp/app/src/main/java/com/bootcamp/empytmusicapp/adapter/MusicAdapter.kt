package com.bootcamp.empytmusicapp.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.R
import com.bootcamp.empytmusicapp.models.Song


class MusicAdapter(val list: List<Song>, val application: Application): RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    class MusicViewHolder(v: View): RecyclerView.ViewHolder(v){
        val title = v.findViewById<TextView>(R.id.rTitle)
        val artist = v.findViewById<Button>(R.id.rArtist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.music_item, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.title
        holder.artist.text = item.artist
    }

    override fun getItemCount(): Int {
        return list.size
    }

}