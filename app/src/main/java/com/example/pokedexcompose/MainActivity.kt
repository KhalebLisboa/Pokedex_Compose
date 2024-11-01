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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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

    val items = viewModel.allPokemon.observeAsState(emptyList())
    var offset = 0
    val context = LocalContext.current
    Log.e("List size", items.value.size.toString())

    LaunchedEffect(offset) {
        viewModel.fetchAll(offset)
    }
    LaunchedEffect(items) {
        Toast.makeText(context, "fetch list", Toast.LENGTH_SHORT).show()
    }
    LazyColumn {
        items(items.value){ pokemon ->
            MainListItem(name = pokemon.name, onClick = {
                offset += 20
                viewModel.fetchAll(offset)
                Toast.makeText(context, "Update offset: $offset", Toast.LENGTH_SHORT).show()
                items.value.forEach {
                    Log.e("test", it.name)
                }
            })
            Log.e("Test", pokemon.name)
        }
    }
}

@Composable
fun MainListItem(modifier: Modifier = Modifier, name: String, onClick : () -> Unit) {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.clickable(onClick = onClick)) {
        AsyncImage(
            model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png",
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