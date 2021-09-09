package com.matheusbrandao.pokemon.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.matheusbrandao.pokemon.R
import com.matheusbrandao.pokemon.databinding.FragmentPokemonDetailBinding
import com.matheusbrandao.pokemon.presentation.pokemon.PokemonBinding
import com.matheusbrandao.pokemon.presentation.pokemon.PokemonDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentPokemonDetailBinding
    private val viewModel by viewModel<PokemonDetailViewModel>()
    private var pokemonData: PokemonBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemonData = it.getSerializable(ARG_POKEMON_DATA) as PokemonBinding?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
        viewDataBinding = FragmentPokemonDetailBinding.bind(root).apply {
            pokemon = pokemonData
            viewModel = this@PokemonDetailFragment.viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        setupActionBar()
        setupObservables()
        setupPokemonDetails()
    }

    private fun setupPokemonDetails() {
        pokemonData?.id?.let {
            viewModel.getDetails(it)
        }
    }

    private fun setupActionBar() {
        activity?.let {
            it.title = pokemonData?.name
        }
    }

    private fun setupObservables() {
        viewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            if (errorMessage.isNotEmpty()) {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val ARG_POKEMON_DATA = "pokemon_data"
    }
}