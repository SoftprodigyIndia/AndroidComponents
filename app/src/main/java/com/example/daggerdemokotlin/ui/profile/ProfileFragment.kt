package com.example.daggerdemokotlin.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.daggerdemokotlin.R
import com.example.daggerdemokotlin.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import java.security.Provider
import javax.inject.Inject

class ProfileFragment :DaggerFragment() {
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory


    lateinit var profileView:ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        Toast.makeText(context,"Load fragment",Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragments_profile,container,false)

        Log.e("profile","Profile Load")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        profileView=ViewModelProvider(this,providerFactory).get(ProfileViewModel::class.java)


    }
}