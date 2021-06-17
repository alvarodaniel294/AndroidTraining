package com.bootcamp.dependency.UI.home

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.dependency.DB.entities.MovieStorageEntity
import com.bootcamp.dependency.databinding.MovieItemBinding
import com.bootcamp.dependency.interfaces.MovieListener
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class HomeMovieAdapter(val listener:MovieListener):RecyclerView.Adapter<HomeMovieAdapter.HomeMovieViewHolder>() {

    lateinit var context:Context
    inner class HomeMovieViewHolder(val binding: MovieItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    private val diffCallBack = object :DiffUtil.ItemCallback<MovieStorageEntity>(){
        override fun areItemsTheSame(
            oldItem: MovieStorageEntity,
            newItem: MovieStorageEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MovieStorageEntity,
            newItem: MovieStorageEntity
        ): Boolean {
            return oldItem == newItem
        }

    }


    private val differ = AsyncListDiffer(this, diffCallBack)
    var movies:List<MovieStorageEntity>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMovieViewHolder {
        context = parent.context
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return HomeMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeMovieViewHolder, position: Int) {
        val item = movies[position]
        holder.binding.title.text = item.title
        Glide
            .with(context)
            .load("https://image.tmdb.org/t/p/w500/${item.poster}")
            .centerCrop()
//            .placeholder(R.drawable.loading_spinner)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.binding.imageVideo)
        holder.binding.imageVideo.setOnClickListener {
            listener.onMovieTap(item.id)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}