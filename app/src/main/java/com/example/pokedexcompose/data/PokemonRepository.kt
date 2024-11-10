package com.example.pokedexcompose.data

import com.example.pokedexcompose.data.model.PokemonDetailsDTO
import com.example.pokedexcompose.data.model.PokemonWithDetails
import com.example.pokedexcompose.data.model.Type
import com.example.pokedexcompose.data.model.toPokeType
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val service: ApiService
) {
    suspend fun fetchAll(offset: Int) : List<PokemonWithDetails> {
        val listPokemon = service.fetchPokemonList(offset).body()
        return listPokemon!!.results.mapIndexed { index, item ->
            PokemonWithDetails(
                name = item.name,
                details = getPokemonData(index)
            ).apply {
                this.details.types.forEach { type: Type ->
                    type.type.pokeType = type.type.name.toPokeType()
                }
            }
        }
    }

    private suspend fun getPokemonData(index : Int) : PokemonDetailsDTO{
        return service.getPokemonData(index + 1).body()!!
    }
}