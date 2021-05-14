package com.bootcamp.emptyapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.emptyapplication.Interfaces.IDogDetail
import com.bootcamp.emptyapplication.databinding.FragmentHomeBinding
import com.squareup.picasso.Picasso

class DogAdapter(val dogs: List<String>, val dogListener : IDogDetail): RecyclerView.Adapter<DogAdapter.DogHolder>() {

    class DogHolder(val view: View): RecyclerView.ViewHolder(view){
        val myView = view
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
        val dogImageUrl = dogs[position]
        holder.render(dogs[position])
        val dogImageView = holder.myView.findViewById<ImageView>(R.id.iv_dog_product)
        dogImageView.setOnClickListener {
            dogListener.didSelectImage(dogImageUrl)
        }
    }

    override fun getItemCount(): Int = dogs.size
}