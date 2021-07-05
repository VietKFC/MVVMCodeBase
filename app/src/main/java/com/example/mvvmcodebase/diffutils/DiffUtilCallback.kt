package com.example.mvvmcodebase.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvmcodebase.data.model.Cocktail

object DiffUtilCallback {

    fun getCocktailDiffUtil() = object : DiffUtil.ItemCallback<Cocktail>() {
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail) =
            oldItem == newItem
    }
}
