package com.example.expediahometest.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expediahometest.data.model.PokemonDetails
import com.example.expediahometest.data.model.PokemonInfo
import com.example.expediahometest.data.network.PokemonRepository
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val repository = PokemonRepository()
    private var offset = 0
    private val limit = 20
    private val pokemonMutableList = MutableLiveData<List<PokemonInfo>>()
    val pokemonList: LiveData<List<PokemonInfo>> = pokemonMutableList
    val currentPokemonMutable = MutableLiveData<PokemonDetails>()

    init {
        loadMore()
    }

    fun loadMore() {
        viewModelScope.launch {
            try {
                val response = repository.getPokemonList(offset, limit)
                pokemonMutableList.value = (pokemonMutableList.value ?: emptyList()) + response.results
                offset += limit
            } catch (e: Exception) {
                // TODO: add error message for the user
                e.printStackTrace()
            }
        }
    }

    fun loadPokemonDetails(url: String){
        viewModelScope.launch {
            try {
                val response = repository.getPokemonDetails(url)
                currentPokemonMutable.value = response
            } catch (e: Exception){
                // TODO: add error message for the user
                e.printStackTrace()
            }
        }
    }
}