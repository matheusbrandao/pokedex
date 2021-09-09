package com.matheusbrandao.pokemon.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheusbrandao.pokemon.R
import com.matheusbrandao.pokemon.databinding.FragmentPokemonListBinding
import com.matheusbrandao.pokemon.presentation.pokemon.PokemonBinding
import com.matheusbrandao.pokemon.presentation.pokemon.PokemonListViewModel
import com.matheusbrandao.pokemon.ui.adapter.PokemonListAdapter
import com.matheusbrandao.pokemon.ui.fragment.PokemonDetailFragment.Companion.ARG_POKEMON_DATA
import com.matheusbrandao.pokemon.ui.utils.OnItemClickListener
import com.orgpick.dannypaginationlibrary.RecyclerScrollChangeListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentPokemonListBinding
    private val viewModel by viewModel<PokemonListViewModel>()
    private lateinit var recyclerView: RecyclerView
    private var offset = 0

    private val onCharacterClickListener = object : OnItemClickListener<PokemonBinding> {
        override fun onItemClick(data: PokemonBinding) {
            val bundle = bundleOf(ARG_POKEMON_DATA to data)
            findNavController().navigate(
                R.id.action_pokemonFragment_to_pokemonDetailFragment,
                bundle
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_pokemon_list, container, false)
        viewDataBinding = FragmentPokemonListBinding.bind(root).apply {
            viewModel = this@PokemonListFragment.viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupListAdapter()
        setupActionBar()
        setupObservables()
        initValues()
    }

    private fun initValues() {
        viewModel.fetchPokemons(offset)
    }

    private fun setupActionBar() {
        activity?.setTitle(R.string.label_title_main)
    }

    private fun setupListAdapter() {
        recyclerView = viewDataBinding.recyclerViewList
        recyclerView.adapter = PokemonListAdapter(emptyList(), onCharacterClickListener)
        recyclerView.layoutManager = GridLayoutManager(
            context, 2,
            GridLayoutManager.VERTICAL, false
        )

        recyclerView.addOnScrollListener(object : RecyclerScrollChangeListener() {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                offset = totalItemsCount;
                viewModel.fetchPokemons(offset)
            }
        })
    }

    private fun setupObservables() {
        viewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            if (errorMessage.isNotEmpty()) {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
