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
    val sprites: SpritesDTO,
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

data class SpritesDTO(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?,
    val other: OtherSpritesDTO
)

data class OtherSpritesDTO(
    val dream_world: DreamWorldDTO,
    val home: HomeDTO,
    val official_artwork: OfficialArtworkDTO,
    val showdown: ShowdownDTO
)

data class DreamWorldDTO(
    val front_default: String?,
    val front_female: String?
)

data class HomeDTO(
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class OfficialArtworkDTO(
    val front_default: String,
    val front_shiny: String?
)

data class ShowdownDTO(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
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
    val url: String,
    var pokeType : PokeType
)

fun String.toPokeType() : PokeType{
    return when (this.lowercase()) {
        "normal" -> PokeType.Normal
        "fighting" -> PokeType.Fighting
        "flying" -> PokeType.Flying
        "poison" -> PokeType.Poison
        "ground" -> PokeType.Ground
        "rock" -> PokeType.Rock
        "bug" -> PokeType.Bug
        "ghost" -> PokeType.Ghost
        "steel" -> PokeType.Steel
        "fire" -> PokeType.Fire
        "water" -> PokeType.Water
        "grass" -> PokeType.Grass
        "electric" -> PokeType.Electric
        "psychic" -> PokeType.Psychic
        "ice" -> PokeType.Ice
        "dragon" -> PokeType.Dragon
        "dark" -> PokeType.Dark
        "fairy" -> PokeType.Fairy
        else -> PokeType.Normal
    }
}
