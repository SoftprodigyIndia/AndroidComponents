package com.example.daggerdemokotlin.ui

import androidx.lifecycle.ViewModel
import com.example.daggerdemokotlin.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap




@Module
abstract class MainActivityViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindAuthViewModel(viewModel: MainViewModel): ViewModel
}