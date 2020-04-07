package com.example.daggerdemokotlin

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggerdemokotlin.ui.MainViewModel
import com.example.daggerdemokotlin.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this, providerFactory).get(MainViewModel::class.java)

        callLogin()


        setLogo()


    }

    private fun callLogin() {
        CoroutineScope(IO).launch {
            mainViewModel.login(1)

        }

        mainViewModel.mutableMain.observe(this, Observer {

            Log.e("name",it.name)
        })

    }

    fun setLogo() {
        requestManager.load(logo).into(imv)
    }
}
