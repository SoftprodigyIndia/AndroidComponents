package com.example.daggerdemokotlin.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerdemokotlin.R
import com.example.daggerdemokotlin.ui.postfragment.PostFragment
import com.example.daggerdemokotlin.ui.profile.ProfileFragment
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_home.*
import nl.joery.animatedbottombar.AnimatedBottomBar
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var homeFragment:PostFragment

    @Inject
    lateinit var profileFragment: ProfileFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setBottom()
    }

    private fun setBottom() {
        bottom_bar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener{
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {

                selectTab(newIndex)
            }

        })
    }

    private fun selectTab(newIndex: Int) {
        when(newIndex){
            0->{
                loadFragment(homeFragment)
            }
            2->{
                loadFragment(profileFragment)
            }


        }


    }
    private fun loadFragment(frag: DaggerFragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, frag)
            .commit()

    }
}
