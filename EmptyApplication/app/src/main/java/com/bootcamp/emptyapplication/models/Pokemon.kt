package com.bootcamp.emptyapplication.models

data class Pokemon (
    val name: String,
    val id: String,
    val height: String,
    val weight: String
) {
    companion object {
        fun getPokemonList():MutableList<Pokemon> {
            val pokemonList = mutableListOf<Pokemon>()
            pokemonList.add(Pokemon("Bulbasaur", "1", "60", "100"))
            pokemonList.add(Pokemon("Ivysaur", "2", "90", "150"))
            pokemonList.add(Pokemon("Venusaur", "3", "120", "200"))
            pokemonList.add(Pokemon("Charmander", "4", "75", "90"))
            pokemonList.add(Pokemon("Charmeleon", "5", "100", "125"))
            pokemonList.add(Pokemon("Charizard", "6", "150", "210"))
            pokemonList.add(Pokemon("Squirtle", "7", "50", "105"))
            pokemonList.add(Pokemon("Wartortle", "8", "100", "130"))
            pokemonList.add(Pokemon("Blastoise", "9", "145", "160"))
            return  pokemonList
        }
    }
}