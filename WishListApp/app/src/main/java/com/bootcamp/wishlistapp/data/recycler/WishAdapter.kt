package com.bootcamp.wishlistapp.data.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.wishlistapp.R
import com.bootcamp.wishlistapp.data.Wish
import com.bootcamp.wishlistapp.data.WishListener
import com.bootcamp.wishlistapp.databinding.WishItemBinding

class WishAdapter(val wishes: List<Wish>, wishListener: WishListener): RecyclerView.Adapter<WishAdapter.WishHolder>(){
    class WishHolder(val view: View): RecyclerView.ViewHolder(view){
        val wishBinding: WishItemBinding = WishItemBinding.bind(view)
        fun render(wish: Wish){
            wishBinding.wishText.text = wish.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishAdapter.WishHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WishHolder(inflater.inflate(R.layout.wish_item,parent,false))
    }

    override fun onBindViewHolder(holder: WishAdapter.WishHolder, position: Int) {
        val currentWish = wishes[position]
        holder.render(currentWish)
        holder.wishBinding.editButton.setOnClickListener {

        }
        holder.wishBinding.deleteButton.setOnClickListener {
            //TODO: delete your wish, but first show an alert
        }
    }

    override fun getItemCount(): Int = wishes.size
}