package com.example.daggerdemokotlin.ui.profile

import androidx.lifecycle.ViewModel
import com.example.daggerdemokotlin.di.ViewModelKey
import com.example.daggerdemokotlin.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileAuthModel {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun profileViewModel(profileViewModel: ProfileViewModel):ViewModel

}