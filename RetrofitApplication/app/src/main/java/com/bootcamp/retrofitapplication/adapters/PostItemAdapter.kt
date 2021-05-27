package com.bootcamp.retrofitapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.retrofitapplication.R
import com.bootcamp.retrofitapplication.models.PostItem

class PostItemAdapter(var list: List<PostItem>) :
    RecyclerView.Adapter<PostItemAdapter.PostItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_layout, parent, false)
        return PostItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostItemViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.title ?: "a"
        holder.desc.text = item.description ?: "b"
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PostItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val desc: TextView = view.findViewById(R.id.description)
    }
}