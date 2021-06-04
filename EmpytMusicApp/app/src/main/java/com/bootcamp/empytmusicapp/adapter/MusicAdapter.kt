package com.bootcamp.empytmusicapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.R
import com.bootcamp.empytmusicapp.listener.SongListener
import com.bootcamp.empytmusicapp.models.Song

class SongAdapter (val list:List<Song>,val listener: SongListener): RecyclerView
.Adapter<SongAdapter
.SongViewHolder>() {

    class SongViewHolder(v: View): RecyclerView.ViewHolder(v){
        val nane = v.findViewById<TextView>(R.id.songName)
        val description = v.findViewById<TextView>(R.id.songDescription)
        val cardview = v.findViewById<CardView>(R.id.songCardView)
        val watchDetailMusic = v.findViewById<Button>(R.id.watchDetailMusic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_item, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val item = list[position]

        holder.nane.text = item.title
        holder.description.text = item.artist
        holder.cardview.setOnClickListener {
            listener.onClickToPlay(item)
        }
        holder.watchDetailMusic.setOnClickListener {
            listener.onClickToWatchDetail(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}