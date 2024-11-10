package com.example.pokedexcompose.data.model

import androidx.compose.ui.graphics.Color

sealed class PokeType(
    val superEffective: List<PokeType>,
    val notEffective: List<PokeType>,
    val nilEffective: List<PokeType>,
    val color: Color
) {
    data object Normal : PokeType(
        superEffective = emptyList(),
        notEffective = listOf(Rock, Steel),
        nilEffective = listOf(Ghost),
        color = Color(0xFFA8A8A8)
    )

    data object Fire : PokeType(
        superEffective = listOf(Bug, Steel, Grass, Ice),
        notEffective = listOf(Rock, Fire, Water, Dragon),
        nilEffective = emptyList(),
        color = Color(0xFFF08030)
    )

    data object Water : PokeType(
        superEffective = listOf(Ground, Rock, Fire),
        notEffective = listOf(Water, Grass, Dragon),
        nilEffective = emptyList(),
        color = Color(0xFF6890F0)
    )

    data object Electric : PokeType(
        superEffective = listOf(Flying, Water),
        notEffective = listOf(Grass, Electric, Dragon),
        nilEffective = listOf(Ground),
        color = Color(0xFFF8B00F)
    )

    data object Grass : PokeType(
        superEffective = listOf(Ground, Rock, Water),
        notEffective = listOf(Flying, Poison, Bug, Steel, Fire, Grass, Dragon),
        nilEffective = emptyList(),
        color = Color(0xFF78C851)
    )

    data object Ice : PokeType(
        superEffective = listOf(Flying, Ground, Grass, Dragon),
        notEffective = listOf(Steel, Fire, Water, Ice),
        nilEffective = emptyList(),
        color = Color(0xFF98D9D8)
    )

    data object Fighting : PokeType(
        superEffective = listOf(Normal, Rock, Steel, Ice, Dark),
        notEffective = listOf(Flying, Poison, Bug, Psychic, Fairy),
        nilEffective = listOf(Ghost),
        color = Color(0xFFE83001)
    )

    data object Poison : PokeType(
        superEffective = listOf(Grass, Fairy),
        notEffective = listOf(Poison, Ground, Rock, Ghost),
        nilEffective = listOf(Steel),
        color = Color(0xFFA040A0)
    )

    data object Ground : PokeType(
        superEffective = listOf(Poison, Rock, Steel, Fire, Electric),
        notEffective = listOf(Bug, Grass),
        nilEffective = listOf(Flying),
        color = Color(0xFFD8E02F)
    )

    data object Flying : PokeType(
        superEffective = listOf(Fighting, Bug, Grass),
        notEffective = listOf(Rock, Steel, Electric),
        nilEffective = emptyList(),
        color = Color(0xFF9F94BE)
    )

    data object Psychic : PokeType(
        superEffective = listOf(Fighting, Poison),
        notEffective = listOf(Steel, Psychic),
        nilEffective = listOf(Dark),
        color = Color(0xFFF85888)
    )

    data object Bug : PokeType(
        superEffective = listOf(Grass, Psychic, Dark),
        notEffective = listOf(Fighting, Flying, Poison, Ghost, Steel, Fire, Fairy),
        nilEffective = emptyList(),
        color = Color(0xFFA8B821)
    )

    data object Rock : PokeType(
        superEffective = listOf(Flying, Bug, Fire, Ice),
        notEffective = listOf(Fighting, Ground, Steel),
        nilEffective = emptyList(),
        color = Color(0xFFB8A038)
    )

    data object Ghost : PokeType(
        superEffective = listOf(Ghost, Psychic),
        notEffective = listOf(Dark),
        nilEffective = listOf(Normal),
        color = Color(0xFF5D4674)
    )

    data object Dragon : PokeType(
        superEffective = listOf(Dragon),
        notEffective = listOf(Steel),
        nilEffective = listOf(Fairy),
        color = Color(0xFF623BD5)
    )

    data object Dark : PokeType(
        superEffective = listOf(Ghost, Psychic),
        notEffective = listOf(Fighting, Dark, Fairy),
        nilEffective = emptyList(),
        color = Color(0xFF776554)
    )

    data object Steel : PokeType(
        superEffective = listOf(Rock, Ice, Fairy),
        notEffective = listOf(Steel, Fire, Water, Electric),
        nilEffective = emptyList(),
        color = Color(0xFFB1ADBB)
    )

    data object Fairy : PokeType(
        superEffective = listOf(Fighting, Dragon, Dark),
        notEffective = listOf(Poison, Steel, Fire),
        nilEffective = emptyList(),
        color = Color(0xFFF8B8E8)
    )
}

val types: List<PokeType> = listOf(
    PokeType.Normal,
    PokeType.Fire,
    PokeType.Water,
    PokeType.Electric,
    PokeType.Grass,
    PokeType.Ice,
    PokeType.Fighting,
    PokeType.Poison,
    PokeType.Ground,
    PokeType.Flying,
    PokeType.Psychic,
    PokeType.Bug,
    PokeType.Rock,
    PokeType.Ghost,
    PokeType.Dragon,
    PokeType.Dark,
    PokeType.Steel,
    PokeType.Fairy
)
