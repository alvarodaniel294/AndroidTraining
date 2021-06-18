package com.bootcamp.mvvmusers.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.bootcamp.mvvmusers.databinding.UserItemBinding
import com.bootcamp.mvvmusers.model.User

class UserAdapter(
    private val values: List<User>
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.name.text = item.name
        holder.userName.text = item.username
        holder.email.text = item.email
        holder.phone.text = item.phone

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.name
        val userName: TextView = binding.userName
        val email: TextView = binding.email
        val phone: TextView = binding.phone
    }

}