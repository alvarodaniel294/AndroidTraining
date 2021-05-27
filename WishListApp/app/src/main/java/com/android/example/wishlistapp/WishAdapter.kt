package com.android.example.wishlistapp

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.example.wishlistapp.Entities.Wish
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WishAdapter(val list: List<Wish>, val application: Application): RecyclerView.Adapter<WishAdapter.WishViewHolder>() {
//    var context: Context? = null
    class WishViewHolder(v: View): RecyclerView.ViewHolder(v){
        val title = v.findViewById<TextView>(R.id.wishText)
        val deleteButton = v.findViewById<Button>(R.id.deleteButton)
        val update = v.findViewById<Button>(R.id.editButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wish_item, parent, false)
        return WishViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.value
        holder.deleteButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                val app = application.applicationContext as WishApp
                val wishToDelete = Wish(item.id, item.value, item.priority,item.owner)
                app.wishDB.wishDao().removeWish(wishToDelete)
            }
        }

        holder.update.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                val app = application.applicationContext as WishApp
                val wishToSave = Wish(item.id, "comer pan con pollo", item.priority,item.owner)
                app.wishDB.wishDao().addWish(wishToSave)
            }
        }

    }


    override fun getItemCount(): Int {
        return list.size
    }
}