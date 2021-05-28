package com.bootcamp.wishlistapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.wishlistapp.databinding.WishItemBinding
import com.bootcamp.wishlistapp.entities.Wish
import com.bootcamp.wishlistapp.interfaces.WishListListener

class WishAdapter(private var list: List<Wish>, val listener: WishListListener): RecyclerView.Adapter<WishAdapter.ViewHolder>() {

    class ViewHolder(private val binding: WishItemBinding, var listener: WishListListener): RecyclerView.ViewHolder(binding.root) {
        fun bind(wish: Wish) {
            binding.wishText.text = """${wish.text} - Owner: ${wish.owner} - Priority: ${wish.priority}"""
            binding.deleteButton.setOnClickListener {
                listener.didRemovePressed(wish)
            }
            binding.editButton.setOnClickListener {
                listener.didEditPressed(wish)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(WishItemBinding.inflate(LayoutInflater.from(parent.context), parent,false), listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}