package com.example.expediahometest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.expediahometest.R
import com.example.expediahometest.databinding.FragmentPokemonDetailsBinding

class PokemonDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPokemonDetailsBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPokemonDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentPokemonMutable.observe(viewLifecycleOwner) { pokemon ->
            binding.tvPokemonName.text = getString(R.string.pokemon_name, pokemon.name.replace("-", "").capitalize())
            binding.tvPokemonHeight.text = getString(R.string.pokemon_height, pokemon.height)
            binding.tvPokemonOrder.text = getString(R.string.pokemon_order_number, pokemon.order)
            binding.tvPokemonWeight.text = getString(R.string.pokemon_weight, pokemon.weight)
        }
    }
}