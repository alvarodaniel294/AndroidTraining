package com.bootcamp.wishlistapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.wishlistapp.R
import com.bootcamp.wishlistapp.databinding.WishItemBinding
import com.bootcamp.wishlistapp.entities.Wish
import java.util.ArrayList

class WishAdapter(private var list: List<Wish>, private var context: Context): RecyclerView.Adapter<WishAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = WishItemBinding.bind(view)
        fun show(wish: Wish) {
            binding.wishText.text = wish.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.wish_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.show(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


}