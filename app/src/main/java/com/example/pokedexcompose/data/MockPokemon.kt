package com.example.pokedexcompose.data

import com.example.pokedexcompose.data.model.Ability
import com.example.pokedexcompose.data.model.AbilityDetail
import com.example.pokedexcompose.data.model.Form
import com.example.pokedexcompose.data.model.Move
import com.example.pokedexcompose.data.model.MoveDetail
import com.example.pokedexcompose.data.model.MoveLearnMethod
import com.example.pokedexcompose.data.model.PokemonDetailsDTO
import com.example.pokedexcompose.data.model.PokemonWithDetails
import com.example.pokedexcompose.data.model.Species
import com.example.pokedexcompose.data.model.Sprites
import com.example.pokedexcompose.data.model.Stat
import com.example.pokedexcompose.data.model.StatDetail
import com.example.pokedexcompose.data.model.Type
import com.example.pokedexcompose.data.model.TypeDetail
import com.example.pokedexcompose.data.model.VersionGroup
import com.example.pokedexcompose.data.model.VersionGroupDetail

val pokemonResponse = PokemonDetailsDTO(
    abilities = listOf(
        Ability(
            ability = AbilityDetail(
                name = "overgrow",
                url = "https://pokeapi.co/api/v2/ability/65/"
            ),
            is_hidden = false,
            slot = 1
        ),
        Ability(
            ability = AbilityDetail(
                name = "chlorophyll",
                url = "https://pokeapi.co/api/v2/ability/34/"
            ),
            is_hidden = true,
            slot = 3
        )
    ),
    base_experience = 236,
    forms = listOf(
        Form(
            name = "venusaur",
            url = "https://pokeapi.co/api/v2/pokemon-form/3/"
        )
    ),
    height = 20,
    id = 3,
    is_default = true,
    location_area_encounters = "https://pokeapi.co/api/v2/pokemon/3/encounters",
    moves = listOf(
        Move(
            move = MoveDetail(
                name = "tackle",
                url = "https://pokeapi.co/api/v2/move/33/"
            ),
            version_group_details = listOf(
                VersionGroupDetail(
                    level_learned_at = 1,
                    move_learn_method = MoveLearnMethod(
                        name = "level-up",
                        url = "https://pokeapi.co/api/v2/move-learn-method/1/"
                    ),
                    version_group = VersionGroup(
                        name = "red-blue",
                        url = "https://pokeapi.co/api/v2/version-group/1/"
                    )
                )
            )
        )
    ),
    name = "venusaur",
    order = 3,
    species = Species(
        name = "venusaur",
        url = "https://pokeapi.co/api/v2/pokemon-species/3/"
    ),
    sprites = Sprites(
        front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png"
    ),
    stats = listOf(
        Stat(
            base_stat = 80,
            effort = 0,
            stat = StatDetail(
                name = "hp",
                url = "https://pokeapi.co/api/v2/stat/1/"
            )
        ),
        Stat(
            base_stat = 82,
            effort = 0,
            stat = StatDetail(
                name = "attack",
                url = "https://pokeapi.co/api/v2/stat/2/"
            )
        )
    ),
    types = listOf(
        Type(
            type = TypeDetail(
                name = "grass",
                url = "https://pokeapi.co/api/v2/type/12/"
            )
        ),
//        Type(
//            type = TypeDetail(
//                name = "poison",
//                url = "https://pokeapi.co/api/v2/type/4/"
//            )
//        )
    ),
    weight = 1000
)

val pokemonWithDetailsMock = PokemonWithDetails(
    name = "Teste",
    details = pokemonResponse
)
