package com.bootcamp.empytmusicapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.databinding.SongItemContainerBinding
import com.bootcamp.empytmusicapp.listeners.SongListener
import com.bootcamp.empytmusicapp.models.Song

class SongAdapter(val songList: MutableList<Song>, val listener: SongListener) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
    class SongViewHolder(container: SongItemContainerBinding): RecyclerView.ViewHolder(container.root) {
        val binding: SongItemContainerBinding = container
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = SongItemContainerBinding.inflate(inflater, parent, false)
        return SongViewHolder(view)
    }
    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val songItem = songList[position]
        holder.binding.songName.text = songItem.name
        holder.binding.songAuthor.text = songItem.author
        holder.binding.songImage.setOnClickListener {
            listener.playSong(songItem)
        }
        holder.binding.songContainer.setOnClickListener {
            listener.viewSongDetail(songItem)
        }
    }
    override fun getItemCount(): Int {
        return songList.size
    }
}