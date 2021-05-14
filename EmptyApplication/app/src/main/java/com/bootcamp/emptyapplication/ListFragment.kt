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
        pokemonList.add(Pokemon("Chicorita", "152", "55", "70"))
        pokemonList.add(Pokemon("Bayleef", "153", "100", "100"))
        pokemonList.add(Pokemon("Meganium", "154", "150", "150"))
        pokemonList.add(Pokemon("Cyndaquil", "155", "75", "90"))
        pokemonList.add(Pokemon("Quilava", "156", "105", "135"))
        pokemonList.add(Pokemon("Typhlosion", "157", "175", "165"))
        pokemonList.add(Pokemon("Totodile", "158", "75", "80"))
        pokemonList.add(Pokemon("Croconaw", "159", "120", "125"))
        pokemonList.add(Pokemon("Feraligatr", "160", "180", "165"))
        adapter.notifyDataSetChanged()
    }

    override fun viewPokemonDetail(pokemon: Pokemon) {
        val navController = findNavController()
        val bundle = Bundle()
        bundle.putString(DetailFragment.POKEMONNAME, pokemon.name)
        bundle.putString(DetailFragment.POKEMOIMAGEID, pokemon.id)
        bundle.putString(DetailFragment.POKEMONWEIGHT, pokemon.weight)
        bundle.putString(DetailFragment.POKEMONHEIGHT, pokemon.height)
        navController.navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }
}