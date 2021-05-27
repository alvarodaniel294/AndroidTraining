package com.bootcamp.persistenceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.persistenceapp.entities.Todo

class TodoAdapter (val list:List<Todo>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(v: View):RecyclerView.ViewHolder(v){
        val title = v.findViewById<TextView>(R.id.todoTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.value
    }

    override fun getItemCount(): Int {
        return list.size
    }
}