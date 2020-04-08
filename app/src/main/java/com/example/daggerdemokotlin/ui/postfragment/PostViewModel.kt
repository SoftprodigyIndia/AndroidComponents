package com.example.daggerdemokotlin.ui.postfragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerdemokotlin.network.ApiInterface
import javax.inject.Inject

class PostViewModel :ViewModel {
     var apiInterface: ApiInterface?=null

    val mutablePost=MutableLiveData<ArrayList<Post>>()

    @Inject
    constructor(apiInterface:ApiInterface){
        this.apiInterface=apiInterface

        if(this.apiInterface==null){

        }else{
            Log.e("post","post view model")

        }
    }


    suspend fun postCall(){
        try{
            mutablePost.postValue(apiInterface?.getPostUser(4)?.body())

        }catch (e:Exception){
            Log.e("post",e.message)
        }

    }
}