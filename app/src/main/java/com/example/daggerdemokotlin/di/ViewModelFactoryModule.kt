package com.example.daggerdemokotlin.di

import androidx.lifecycle.ViewModelProvider
import com.example.daggerdemokotlin.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory?): ViewModelProvider.Factory?
}