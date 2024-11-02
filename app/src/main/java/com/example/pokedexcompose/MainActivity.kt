package com.example.pokedexcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                Scaffold(modifier = Modifier.fillMaxSize()){
                    MainList()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MainList(viewModel: MainViewModel = hiltViewModel()){

    val items by viewModel.allPokemon.collectAsStateWithLifecycle()
    val size by remember{ mutableIntStateOf(items.size) }
    val context = LocalContext.current
    Log.e("List size", items.size.toString())

    LaunchedEffect(Unit) {
        viewModel.fetchAll(0)
    }

    LazyColumn {
        itemsIndexed(items){ position, pokemon ->
            MainListItem(name = pokemon.name, index = position + 1, onClick = {
                viewModel.updateOffset()
                viewModel.fetchAll()

            })
        }
    }
}

@Composable
fun MainListItem(modifier: Modifier = Modifier, name: String, index : Int, onClick : () -> Unit) {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.clickable(onClick = onClick)) {
        AsyncImage(
            model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png",
            contentDescription = null,
            modifier = modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.Red)
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexComposeTheme {
//        MainListItem(modifier = Modifier, name = "pokemon")
    }
}