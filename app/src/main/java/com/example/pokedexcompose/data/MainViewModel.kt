package com.example.pokedexcompose.data

import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexcompose.data.model.PokemonResultDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {


    private val _allPokemon : MutableLiveData<ArrayList<PokemonResultDTO>> = MutableLiveData()
    val allPokemon : LiveData<ArrayList<PokemonResultDTO>> = _allPokemon


    fun fetchAll(offset: Int = 0) {
        viewModelScope.launch {
//            _allPokemon.value!!.addAll(repository.fetchAll(offset).body()!!.results)
        }
    }
}