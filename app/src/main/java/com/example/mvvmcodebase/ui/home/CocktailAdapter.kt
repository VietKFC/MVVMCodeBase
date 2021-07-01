package com.example.mvvmcodebase.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcodebase.data.model.Cocktail
import com.example.mvvmcodebase.databinding.ItemCocktailBinding
import com.example.mvvmcodebase.utils.loadImageByUrl

class CocktailAdapter : RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {

    private val cocktails = mutableListOf<Cocktail>()

    fun setCocktails(cocktails: List<Cocktail>) {
        this.cocktails.apply {
            clear()
            addAll(cocktails)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(cocktails[position])
    }

    override fun getItemCount() = cocktails.size

    class ViewHolder(itemView: View, private val binding: ItemCocktailBinding) :
        RecyclerView.ViewHolder(itemView) {

        fun bindView(cocktail: Cocktail) {
            binding.apply {
                imageCocktail.loadImageByUrl(cocktail.strDrinkThumb)
                textName.text = cocktail.strDrink
                textInfor.text = cocktail.strCategory
            }
        }
    }
}
