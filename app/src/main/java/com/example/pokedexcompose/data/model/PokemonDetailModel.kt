package com.example.pokedexcompose.data.model

data class PokemonWithDetails(
    val name : String,
    val details : PokemonDetailsDTO
)

data class PokemonDetailsDTO(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val height: Int,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)

data class Ability(
    val ability: AbilityDetail,
    val is_hidden: Boolean,
    val slot: Int
)

data class AbilityDetail(
    val name: String,
    val url: String
)

data class Form(
    val name: String,
    val url: String
)

data class Move(
    val move: MoveDetail,
    val version_group_details: List<VersionGroupDetail>
)

data class MoveDetail(
    val name: String,
    val url: String
)

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: MoveLearnMethod,
    val version_group: VersionGroup
)

data class MoveLearnMethod(
    val name: String,
    val url: String
)

data class VersionGroup(
    val name: String,
    val url: String
)

data class Species(
    val name: String,
    val url: String
)

data class Sprites(
    val front_default: String
)

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: StatDetail
)

data class StatDetail(
    val name: String,
    val url: String
)

data class Type(
    val type: TypeDetail
)

data class TypeDetail(
    val name: String,
    val url: String
)
