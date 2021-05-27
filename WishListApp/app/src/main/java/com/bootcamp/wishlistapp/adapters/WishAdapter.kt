package com.bootcamp.wishlistapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.wishlistapp.databinding.WishItemBinding
import com.bootcamp.wishlistapp.entities.Wish

class WishAdapter(var wishList: List<Wish>): RecyclerView.Adapter<WishAdapter.WishViewHolder>() {

    class WishViewHolder(container: WishItemBinding): RecyclerView.ViewHolder(container.root) {
        val binding: WishItemBinding = container
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = WishItemBinding.inflate(inflater, parent, false)
        return WishViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        val wish = wishList[position]
        holder.binding.wishText.text = wish.text
    }

    override fun getItemCount(): Int {
        return wishList.size
    }
}