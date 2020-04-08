package com.example.daggerdemokotlin.di.fragmentmodule

import com.example.daggerdemokotlin.ui.postfragment.PostAuthModel
import com.example.daggerdemokotlin.ui.postfragment.PostFragment
import com.example.daggerdemokotlin.ui.postfragment.PostViewModel
import com.example.daggerdemokotlin.ui.profile.ProfileAuthModel
import com.example.daggerdemokotlin.ui.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentMainBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(ProfileAuthModel::class))
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector(modules = arrayOf(PostAuthModel::class))
    abstract fun contributePostFragment(): PostFragment

}