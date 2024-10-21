package com.example.pokedexcompose.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResponseDTO(
    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String? = null,

    @SerializedName("previous")
    val previous: String? = null,

    @SerializedName("results")
    val results: List<PokemonResultDTO>
)