package com.bootcamp.emptyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.emptyapplication.adapters.PokemonAdapter
import com.bootcamp.emptyapplication.databinding.FragmentListBinding
import com.bootcamp.emptyapplication.models.Pokemon

class ListFragment : Fragment(), PokemonListener {

    lateinit var pokemonList: MutableList<Pokemon>
    lateinit var adapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonList = Pokemon.getPokemonList()
        adapter = PokemonAdapter(pokemonList, this)

        val recycler: RecyclerView = view?.findViewById(R.id.recyclerList) as RecyclerView
        recycler.layoutManager = LinearLayoutManager(parentFragment?.context)
        recycler.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun viewPokemonDetail(pokemon: Pokemon) {
        val navController = findNavController()
        val bundle = Bundle()
        navController.navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }
}