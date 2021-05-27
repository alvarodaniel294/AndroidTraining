package com.bootcamp.wishlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.wishlistapp.listener.WishListener


class WishAdapter (val list:List<Wish>, val listener: WishListener): RecyclerView.Adapter<WishAdapter
.WishViewHolder>() {

    class WishViewHolder(v: View): RecyclerView.ViewHolder(v){
        val title = v.findViewById<TextView>(R.id.wishText)
        val removeButton = v.findViewById<Button>(R.id.deleteButton)
        val editButton = v.findViewById<Button>(R.id.editButton)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wish_item, parent, false)
        return WishViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        val item = list[position]
        val sb = StringBuilder()
        sb.append("Wish:" + item.wish + "\n")
        sb.append("Priority:" + item.priority + "\n")
        sb.append("Owner:" + item.owner )
        holder.title.text = sb.toString()

        holder.removeButton.setOnClickListener {
            listener.onRemoveItem(position)
        }

        holder.editButton.setOnClickListener {
            listener.onEditItem(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}