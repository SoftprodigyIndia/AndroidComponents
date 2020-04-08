package com.example.daggerdemokotlin.ui.postfragment

import androidx.lifecycle.ViewModel
import com.example.daggerdemokotlin.di.ViewModelKey
import com.example.daggerdemokotlin.ui.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class PostAuthModel {

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract  fun postViewModel(postViewModel: PostViewModel):ViewModel

}