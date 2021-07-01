package com.example.mvvmcodebase.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmcodebase.R

fun ImageView.loadImageByUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_launcher_background)
        .placeholder(R.drawable.ic_launcher_background)
        .into(this)
}
