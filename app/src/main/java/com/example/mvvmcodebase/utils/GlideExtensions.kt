package com.example.mvvmcodebase.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mvvmcodebase.R

@BindingAdapter("app:imageUrl")
fun ImageView.loadImageByUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_launcher_background)
        .placeholder(R.drawable.ic_launcher_background)
        .into(this)
}
