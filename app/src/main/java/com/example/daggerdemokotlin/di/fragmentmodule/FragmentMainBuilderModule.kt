package com.example.daggerdemokotlin.di.fragmentmodule

import android.provider.ContactsContract
import com.example.daggerdemokotlin.ui.postfragment.PostAuthModel
import com.example.daggerdemokotlin.ui.postfragment.PostFragment
import com.example.daggerdemokotlin.ui.postfragment.PostViewModel
import com.example.daggerdemokotlin.ui.profile.ProfileAuthModel
import com.example.daggerdemokotlin.ui.profile.ProfileFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentMainBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(ProfileAuthModel::class))
        abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector(modules = arrayOf(PostAuthModel::class))
    abstract fun contributePostFragment(): PostFragment

    @Module
    companion object{

        @Provides
        @JvmStatic
        fun profileFragment():ProfileFragment{
            return  ProfileFragment()
        }

        @Provides
        @JvmStatic
        fun  homeFragment():PostFragment{
            return  PostFragment()
        }

    }

}