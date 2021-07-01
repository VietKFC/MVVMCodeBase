package com.example.mvvmcodebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmcodebase.ui.home.HomeFragment
import com.example.mvvmcodebase.utils.addFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(supportFragmentManager , HomeFragment())
    }
}