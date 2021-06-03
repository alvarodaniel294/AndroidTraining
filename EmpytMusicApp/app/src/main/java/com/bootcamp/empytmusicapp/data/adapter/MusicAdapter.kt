package com.bootcamp.empytmusicapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.empytmusicapp.R
import com.bootcamp.empytmusicapp.data.IMusic
import com.bootcamp.empytmusicapp.data.model.Music
import com.bootcamp.empytmusicapp.databinding.MusicItemBinding

class MusicAdapter(val musicList: List<Music>, val listener: IMusic): RecyclerView.Adapter<MusicAdapter.MusicHolder>() {
    class MusicHolder(view: View): RecyclerView.ViewHolder(view){
        val musicItemBinding = MusicItemBinding.bind(view)

        fun render(musicItem: Music){
            musicItemBinding.tvSongName.text = musicItem.nombre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicAdapter.MusicHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MusicHolder(layoutInflater.inflate(R.layout.music_item,parent,false))
    }

    override fun onBindViewHolder(holder: MusicAdapter.MusicHolder, position: Int) {
        val currentMusic = musicList[position]
        holder.render(currentMusic)
        holder.musicItemBinding.cvCardview.setOnClickListener {
            listener.didSelectCardView(currentMusic)
        }
        holder.musicItemBinding.ivStopMusic.setOnClickListener {
            listener.didStopButtonPressed()
        }
        holder.musicItemBinding.ivInfo.setOnClickListener {
            listener.didInfoButtonPressed()
        }
    }

    override fun getItemCount(): Int = musicList.size

}