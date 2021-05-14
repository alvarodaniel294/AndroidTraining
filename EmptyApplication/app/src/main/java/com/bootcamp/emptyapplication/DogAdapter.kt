package com.bootcamp.emptyapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DogAdapter(val dogs: List<String>): RecyclerView.Adapter<DogAdapter.DogHolder>() {

    class DogHolder(val view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.iv_dog_product)
        fun render(myUrl: String){
            Picasso.get().load(myUrl).into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogHolder(layoutInflater.inflate(R.layout.dog_item,parent,false))
    }

    override fun onBindViewHolder(holder: DogHolder, position: Int) {
        holder.render(dogs[position])
    }

    override fun getItemCount(): Int = dogs.size
}