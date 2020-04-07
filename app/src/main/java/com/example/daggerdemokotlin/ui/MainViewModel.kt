package com.example.daggerdemokotlin.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerdemokotlin.network.ApiInterface
import javax.inject.Inject


class MainViewModel : ViewModel {
    var apiInterface: ApiInterface? = null
    val mutableMain = MutableLiveData<Users>()


    @Inject
    constructor(apiInterface: ApiInterface) {
        this.apiInterface = apiInterface
        if (this.apiInterface == null) {
            Log.e("ViewModel", "ViewModel is null")

        } else {

            Log.e("ViewModel", "ViewModel is  not null")

        }
    }

    suspend fun login(id: Int) {
        try {
            mutableMain.postValue(this.apiInterface?.loginCall(id)?.body())
            Log.e("error", "success")

        } catch (e: Exception) {
            Log.e("error", e.message)
        }

    }

}