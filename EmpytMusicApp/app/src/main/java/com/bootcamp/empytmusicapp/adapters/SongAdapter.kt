package com.bootcamp.empytmusicapp.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.bootcamp.empytmusicapp.databinding.FragmentSongBinding
import com.bootcamp.empytmusicapp.listeners.SongListener
import com.bootcamp.empytmusicapp.models.Song

class SongAdapter(
    private val values: List<Song>,
    private val listener: SongListener
) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentSongBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = values[position]
        holder.idView.text = song.title
        holder.playButton.setOnClickListener {
            listener.play(song)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentSongBinding) : RecyclerView.ViewHolder(binding.root) {
        val playButton = binding.playButton
        val idView: TextView = binding.titleLabel
    }

}