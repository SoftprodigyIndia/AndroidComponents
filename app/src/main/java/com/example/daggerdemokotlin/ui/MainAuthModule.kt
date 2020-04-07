package com.example.daggerdemokotlin.ui

import com.example.daggerdemokotlin.network.ApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class MainAuthModule {

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun provideAuthApi(retrofit: Retrofit):ApiInterface{
            return   retrofit.create(ApiInterface::class.java)
        }
    }
}