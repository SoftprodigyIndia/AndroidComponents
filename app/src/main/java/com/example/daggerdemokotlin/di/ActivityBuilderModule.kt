package com.example.daggerdemokotlin.di

import com.example.daggerdemokotlin.MainActivity
import com.example.daggerdemokotlin.di.fragmentmodule.FragmentMainBuilderModule
import com.example.daggerdemokotlin.ui.MainActivityViewModelModule
import com.example.daggerdemokotlin.ui.MainAuthModule
import com.example.daggerdemokotlin.ui.home.HomeActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
 public  abstract  class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityViewModelModule::class, MainAuthModule::class))
    abstract  fun mainActivity():MainActivity
    @ContributesAndroidInjector(modules = arrayOf(
        FragmentMainBuilderModule::class, MainAuthModule::class
    ))
    abstract fun homeActivity(): HomeActivity
    @Module
    companion object
    {
        @Provides
        @JvmStatic
        fun addString():String{
            return "hi sam"
        }
    }
}