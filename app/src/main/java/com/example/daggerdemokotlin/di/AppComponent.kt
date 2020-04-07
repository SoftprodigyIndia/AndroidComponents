package com.example.daggerdemokotlin.di

import android.app.Application
import com.example.daggerdemokotlin.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,AppModule::class,ViewModelFactoryModule::class))
 interface AppComponent :AndroidInjector<BaseApplication>{

    @Component.Builder
    interface  Builder{

        @BindsInstance
        fun application(application: Application):Builder

         fun build():AppComponent
    }
}