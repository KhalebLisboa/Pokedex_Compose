package com.example.pokedexcompose

import android.util.Log
import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {


    private val _allPokemon : MutableLiveData<ArrayList<PokemonResultDTO>> = MutableLiveData(
        arrayListOf(PokemonResultDTO(name = "Khaleb", url = ""))
    )
    val allPokemon : LiveData<ArrayList<PokemonResultDTO>> get() = _allPokemon

    private var offset = 0


    fun fetchAll(offset: Int = this.offset) {
        viewModelScope.launch {
            val updatedList : ArrayList<PokemonResultDTO> = _allPokemon.value!!
            updatedList.addAll(repository.fetchAll(offset).body()!!.results)
            _allPokemon.postValue(updatedList)
            Log.e("private size", _allPokemon.value!!.size.toString())
            Log.e("open size", allPokemon.value!!.size.toString())
        }
    }

    fun updateOffset(){
        offset += 20
    }
}