package com.example.daggerdemokotlin.network

import com.example.daggerdemokotlin.ui.Users
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("users/{id}")
    suspend  fun  loginCall(@Path("id") id:Int): Response<Users>
}