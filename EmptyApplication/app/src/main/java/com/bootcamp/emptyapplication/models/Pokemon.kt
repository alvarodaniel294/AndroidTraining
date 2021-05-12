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
            pokemonList.add(Pokemon("Charmander", "4", "60", "100"))
            pokemonList.add(Pokemon("Bulbasaur", "1", "60", "100"))
            pokemonList.add(Pokemon("Squirtle", "7", "60", "100"))
            return  pokemonList
        }
    }
}