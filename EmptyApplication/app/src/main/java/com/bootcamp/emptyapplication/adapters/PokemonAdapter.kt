package com.bootcamp.emptyapplication.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.emptyapplication.databinding.PokemonContainerBinding
import com.bootcamp.emptyapplication.models.Pokemon
import com.squareup.picasso.Picasso
import java.lang.Exception

class PokemonAdapter(var pokemonList: MutableList<Pokemon>): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(container: PokemonContainerBinding): RecyclerView.ViewHolder(container.root) {
        val binding: PokemonContainerBinding = container
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = PokemonContainerBinding.inflate(inflater, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        Log.d("ADAPTER", position.toString())
        val pokemon = pokemonList[position]
        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.id}.png"
        Picasso
            .get()
            .load(imageUrl)
            .into(holder.binding.posterImageView, object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    Log.d("IMAGE SUCCESS", "Success")
                }
                override fun onError(e: Exception?) {
                    Log.d("IMAGE ERROR", e.toString())
                }
            })

    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}