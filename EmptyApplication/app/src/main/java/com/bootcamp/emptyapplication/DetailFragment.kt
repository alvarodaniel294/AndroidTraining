package com.bootcamp.emptyapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.lang.Exception

class DetailFragment : Fragment() {
    companion object {
        const val POKEMONNAME = "pokemonName"
        const val POKEMOIMAGEID = "pokemonImageId"
        const val POKEMONWEIGHT = "pokemonWeight"
        const val POKEMONHEIGHT = "pokemonHeight"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name: String? = arguments?.getString(POKEMONNAME)?: "Pokemon"
        val imageId: String? = arguments?.getString(POKEMOIMAGEID)?: "1"
        val weight: String? = arguments?.getString(POKEMONWEIGHT)?: "0"
        val height: String? = arguments?.getString(POKEMONHEIGHT)?: "0"

        val nameLabel = view.findViewById<TextView>(R.id.name)
        val posterImageView = view.findViewById<ImageView>(R.id.posterImageView)
        val weightLabel = view.findViewById<TextView>(R.id.weight)
        val heightLabel = view.findViewById<TextView>(R.id.height)
        nameLabel.text = "Name: $name"
        weightLabel.text = "Weight: $weight lb"
        heightLabel.text = "Height: $height ft"
        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${imageId}.png"
        Picasso
            .get()
            .load(imageUrl)
            .into(posterImageView, object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    Log.d("IMAGE SUCCESS", "Success")
                }
                override fun onError(e: Exception?) {
                    Log.d("IMAGE ERROR", e.toString())
                }
            })
    }
}