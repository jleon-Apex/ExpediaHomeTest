package com.example.expediahometest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expediahometest.data.model.PokemonInfo
import com.example.expediahometest.databinding.ItemPokemonBinding

class PokemonListAdapter(val onClick : (String) -> (Unit)) : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    private var pokemonList: List<PokemonInfo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.setOnClickListener { onClick(pokemon.url) }
        holder.binding.tvPokemonName.text = pokemon.name.replace("-"," ").capitalize()
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun updateData(newPokemonList: List<PokemonInfo>) {
        pokemonList = newPokemonList
        notifyDataSetChanged()
    }

    inner class PokemonViewHolder(val binding: ItemPokemonBinding) :RecyclerView.ViewHolder(binding.root)
}