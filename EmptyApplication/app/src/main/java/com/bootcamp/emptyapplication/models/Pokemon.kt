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
            pokemonList.add(Pokemon("Ivysaur", "2", "90", "100"))
            pokemonList.add(Pokemon("Venusaur", "3", "120", "100"))
            pokemonList.add(Pokemon("Charmander", "4", "60", "100"))
            pokemonList.add(Pokemon("Charmeleon", "5", "60", "100"))
            pokemonList.add(Pokemon("Charizard", "6", "60", "100"))
            pokemonList.add(Pokemon("Squirtle", "7", "60", "100"))
            pokemonList.add(Pokemon("Wartortle", "8", "60", "100"))
            pokemonList.add(Pokemon("Blastoise", "9", "60", "100"))
            return  pokemonList
        }
    }
}