package com.example.daggerdemokotlin.ui.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ProfileViewModel :ViewModel{

    @Inject
    constructor(){
        Log.e("profile","profile view Model")

    }

}