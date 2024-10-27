package com.example.pokedexcompose

import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val service: ApiService
) {
    suspend fun fetchAll(offset: Int) : Response<PokemonResponseDTO> {
        return service.getData(offset)
    }
}