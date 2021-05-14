package com.bootcamp.emptyapplication.adapters

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bootcamp.emptyapplication.Details
import com.bootcamp.emptyapplication.models.Item
import com.bootcamp.emptyapplication.databinding.FragmentItemBinding
import com.squareup.picasso.Picasso

class MyItemRecyclerViewAdapter(
    private val values: List<Item>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), parent.context
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.show(item)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(private val binding: FragmentItemBinding, var context: Context) : RecyclerView.ViewHolder(binding.root) {
        fun show(item: Item) {
            binding.title.text = item.title
            Picasso.get().load(item.imageUrl).into(binding.imageView)
            binding.card.setOnClickListener {
                context.startActivity(Intent(context, Details::class.java).putExtra("item", item))
            }
        }
    }

}