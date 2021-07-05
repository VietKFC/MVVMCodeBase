package com.example.mvvmcodebase.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcodebase.data.model.Cocktail
import com.example.mvvmcodebase.databinding.ItemCocktailBinding
import com.example.mvvmcodebase.diffutils.DiffUtilCallback

class CocktailAdapter :
    ListAdapter<Cocktail, CocktailAdapter.ViewHolder>(DiffUtilCallback.getCocktailDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCocktailBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    class ViewHolder(private val binding: ItemCocktailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(cocktail: Cocktail) {
            binding.apply {
                this.cocktail = cocktail
            }
        }
    }
}
