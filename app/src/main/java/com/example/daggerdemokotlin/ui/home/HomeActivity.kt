package com.example.daggerdemokotlin.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerdemokotlin.R
import com.example.daggerdemokotlin.ui.postfragment.PostFragment
import dagger.android.support.DaggerAppCompatActivity

class HomeActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager.beginTransaction().
            replace(R.id.frame, PostFragment()).commit()
    }
}
