package com.bootcamp.emptyapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bootcamp.emptyapplication.adapters.PokemonAdapter
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

        val mSwipeRefreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.swiperefresh)
        mSwipeRefreshLayout.setOnRefreshListener {
            addNewPokemon()
            mSwipeRefreshLayout.isRefreshing = false
        }
    }

    private fun addNewPokemon() {
        pokemonList.clear()
        pokemonList.add(Pokemon("Chicorita", "152", "90", "100"))
        pokemonList.add(Pokemon("Bayleef", "153", "120", "100"))
        pokemonList.add(Pokemon("Meganium", "154", "60", "100"))
        pokemonList.add(Pokemon("Cyndaquil", "155", "60", "100"))
        pokemonList.add(Pokemon("Quilava", "156", "60", "100"))
        pokemonList.add(Pokemon("Typhlosion", "157", "60", "100"))
        pokemonList.add(Pokemon("Totodile", "158", "60", "100"))
        pokemonList.add(Pokemon("Croconaw", "159", "60", "100"))
        pokemonList.add(Pokemon("Feraligatr", "160", "60", "100"))
        adapter.notifyDataSetChanged()
    }

    override fun viewPokemonDetail(pokemon: Pokemon) {
        val navController = findNavController()
        val bundle = Bundle()
        navController.navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }
}