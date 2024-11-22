package com.example.pokedexcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.pokedexcompose.data.MainViewModel
import com.example.pokedexcompose.data.model.PokemonWithDetails
import com.example.pokedexcompose.data.pokemonWithDetailsMock
import com.example.pokedexcompose.ui.theme.PokedexComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MainList()
                }
            }
        }
    }
}

@Composable
fun MainList(viewModel: MainViewModel = hiltViewModel()) {

    val items by viewModel.allPokemon.collectAsStateWithLifecycle()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        itemsIndexed(items) { position, pokemon ->
            MainListItem(pokemon = pokemon, index = position + 1, onClick = {
                viewModel.fetchAll()
            })
        }
        item {
            LaunchedEffect(true) {
                viewModel.fetchAll()
            }
        }
    }
}

@Composable
fun MainListItem(
    modifier: Modifier = Modifier,
    pokemon: PokemonWithDetails,
    index: Int,
    onClick: () -> Unit
) {
    val backgroundColor = pokemon.details.types.first().type.pokeType.color

    Box(
        modifier = modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .fillMaxSize()
            .clickable(onClick = onClick)
            .aspectRatio(3f / 2f),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 10.dp, top = 8.dp, bottom = 5.dp)
                .fillMaxHeight()
                .zIndex(2f),
        ) {
            Text(
                text = pokemon.name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.padding(vertical = 5.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(pokemon.details.types) { pokemon ->
                    TextPokemonType(pokemon.type.name)
                }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            Image(
                painter = painterResource(R.drawable.img_pokeball),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = 10.dp, y = 15.dp)
                    .alpha(.6f)
            )
            AsyncImage(
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png",
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun TextPokemonType(typeName: String) {
    Text(
        text = typeName,
        style = TextStyle(
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .background(Color.White.copy(alpha = .2f), shape = RoundedCornerShape(17.dp))
            .padding(horizontal = 10.dp, vertical = 5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexComposeTheme {
        val fakeList = listOf("", "", "", "")

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            items(fakeList) {
                MainListItem(
                    modifier = Modifier,
                    pokemon = pokemonWithDetailsMock,
                    index = 1,
                    onClick = {})
            }
        }
    }
}