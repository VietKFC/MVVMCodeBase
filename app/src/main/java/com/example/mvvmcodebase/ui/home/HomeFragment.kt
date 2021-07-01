package com.example.mvvmcodebase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.mvvmcodebase.data.model.Cocktail
import com.example.mvvmcodebase.databinding.FragmentHomeLayoutBinding
import com.example.mvvmcodebase.utils.Constant
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var binding: FragmentHomeLayoutBinding? = null
    private val cockTailViewModel by viewModel<HomeViewModel>()
    private val adapter = CocktailAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeLayoutBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerCocktail?.adapter = adapter
        cockTailViewModel.getCocktails(Constant.ALPHABET)
        observeData()

    }

    private fun observeData() {
        cockTailViewModel.cocktails.observe(viewLifecycleOwner, cocktailObserver)
        cockTailViewModel.isError.observe(viewLifecycleOwner, errorObserver)
    }

    private val cocktailObserver = Observer<List<Cocktail>> {
        adapter.setCocktails(it)
    }

    private val errorObserver = Observer<Boolean> {

    }
}
