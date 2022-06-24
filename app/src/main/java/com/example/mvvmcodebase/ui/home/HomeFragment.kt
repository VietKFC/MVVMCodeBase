package com.example.mvvmcodebase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.mvvmcodebase.databinding.FragmentHomeLayoutBinding
import com.example.mvvmcodebase.ui.viewmodel.HomeViewModel
import com.example.mvvmcodebase.utils.ApiConstant
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeLayoutBinding
    private val cockTailViewModel by viewModel<HomeViewModel>()
    private val adapter = CocktailAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (!this::binding.isInitialized) {
            binding = FragmentHomeLayoutBinding.inflate(layoutInflater, container, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerCocktail.adapter = adapter
        cockTailViewModel.setCocktailLetter(ApiConstant.ALPHABET)
        observeData()
    }

    private fun observeData() {
        cockTailViewModel.cocktails.observe(viewLifecycleOwner, Observer(adapter::submitList))
        cockTailViewModel.isError.observe(viewLifecycleOwner, errorObserver)
    }

    private val errorObserver = Observer<String> {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }
}
