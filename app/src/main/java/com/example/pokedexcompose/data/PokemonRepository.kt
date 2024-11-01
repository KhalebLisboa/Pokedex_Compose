package com.example.pokedexcompose.data

import com.example.pokedexcompose.data.model.PokemonResponseDTO
import retrofit2.Response
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val service: ApiService
) {
    suspend fun fetchAll(offset: Int) : Response<PokemonResponseDTO> {
        return service.getData(offset)
    }
}