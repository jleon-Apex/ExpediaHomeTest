package com.example.expediahometest.data.network

import android.util.Log
import com.example.expediahometest.data.model.PokemonDetails
import com.example.expediahometest.data.model.PokemonListResponse

class PokemonRepository {
    private val pokemonService = RetrofitClient.createPokemonService()


    suspend fun getPokemonList(offset: Int, limit: Int): PokemonListResponse {
        try {
            val response = pokemonService.getPokemonList(offset, limit)
            if (response.isSuccessful) {
                return response.body()!!
            } else {
                throw Exception("Failed to fetch data")
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun getPokemonDetails(url: String): PokemonDetails {
        try {
            val response = pokemonService.getPokemonDetails(url)
            if (response.isSuccessful) {
                return response.body()!!
            } else {
                throw Exception("Failed to fetch pokemon details")
            }
        } catch (e: Exception) {
            throw e
        }
    }
}