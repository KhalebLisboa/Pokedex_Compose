package com.example.pokedexcompose

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon")
    suspend fun getData(
        @Query("offset") offset : Int
    ) : Response<PokemonResponseDTO>
}