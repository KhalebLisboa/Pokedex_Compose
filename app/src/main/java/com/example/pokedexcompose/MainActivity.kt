package com.example.pokedexcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.pokedexcompose.data.MainViewModel
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

    LaunchedEffect(Unit) {
        viewModel.fetchAll(0)
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        itemsIndexed(items) { position, pokemon ->
            MainListItem(name = pokemon.name, index = position + 1, onClick = {
                viewModel.updateOffset()
                viewModel.fetchAll()
            })
        }
    }
}

@Composable
fun MainListItem(modifier: Modifier = Modifier, name: String, index: Int, onClick: () -> Unit) {
    Card(
        border = BorderStroke(width = 4.dp, color = Color.Transparent), modifier = modifier.padding(10.dp).aspectRatio(3f/2f),
    ) {
        Row(modifier = Modifier
            .fillMaxSize()) {
            Column(
                modifier = Modifier
                    .clickable(onClick = onClick)
                    .padding(horizontal = 10.dp)
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.SpaceAround,
            ) {
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Text(
                    text = name,
                    modifier = Modifier
                )

                Text(
                    text = name,
                    modifier = Modifier
                )
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .clipToBounds()) {

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
                        .size(90.dp)
                        .clip(CircleShape)
                        .align(Alignment.BottomEnd)
                )
            }
        }
    }
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
                MainListItem(modifier = Modifier, name = "pokemon", index = 1, onClick = {})
            }
        }
    }
}