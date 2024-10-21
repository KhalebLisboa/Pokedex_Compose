package com.example.pokedexcompose.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResultDTO(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)