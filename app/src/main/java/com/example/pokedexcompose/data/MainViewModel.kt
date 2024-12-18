package com.example.pokedexcompose.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexcompose.data.model.PokemonWithDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _allPokemon: MutableStateFlow<List<PokemonWithDetails>> =
        MutableStateFlow(emptyList())
    val allPokemon: StateFlow<List<PokemonWithDetails>> = _allPokemon.asStateFlow()
    private var offset = 0

    init {
        fetchAll(offset)
    }

    fun fetchAll(offset: Int = this.offset) {
        viewModelScope.launch {
            val currentList = _allPokemon.value
            val newItems = repository.fetchAll(offset)

            _allPokemon.value = (currentList + newItems)
            this@MainViewModel.offset += 20
        }
    }
}