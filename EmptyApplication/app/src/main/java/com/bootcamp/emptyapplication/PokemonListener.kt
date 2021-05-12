package com.bootcamp.emptyapplication

import com.bootcamp.emptyapplication.models.Pokemon

interface PokemonListener {
    fun viewPokemonDetail(pokemon: Pokemon)
}