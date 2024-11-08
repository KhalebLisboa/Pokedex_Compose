package com.example.pokedexcompose.data

import com.example.pokedexcompose.data.model.PokemonDetailsDTO
import com.example.pokedexcompose.data.model.PokemonResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("offset") offset : Int
    ) : Response<PokemonResponseDTO>

    @GET("pokemon/{index}")
    suspend fun getPokemonData(@Path ("index") index : Int) : Response<PokemonDetailsDTO>
}