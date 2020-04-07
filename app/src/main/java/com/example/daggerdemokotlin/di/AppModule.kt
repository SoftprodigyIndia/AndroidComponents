package com.example.daggerdemokotlin.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerdemokotlin.R
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {
    @Module
    companion object{

        @Provides
        @Singleton
        @JvmStatic
        fun providesRetrofitInstance(): Retrofit {

            val interceptor =  HttpLoggingInterceptor();
   interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
  interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            val client = OkHttpClient.Builder().addInterceptor(interceptor)
                .readTimeout(4, TimeUnit.MINUTES)
                .writeTimeout(4, TimeUnit.MINUTES)
                .connectTimeout(4, TimeUnit.MINUTES)
                .build()
            return Retrofit.Builder()
                .baseUrl(WebConstant.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @JvmStatic
        fun provideRequestOption():RequestOptions
        {
        return  RequestOptions.placeholderOf(R.drawable.image).error(R.drawable.image)
        }

        @Provides
        @JvmStatic
        fun provideGlideInstance(application: Application,requestOptions: RequestOptions):RequestManager {
            return Glide.with(application).setDefaultRequestOptions(requestOptions)
        }

        @Provides
        @JvmStatic
        fun provideAppDrawable(application: Application):Drawable{
            return ContextCompat.getDrawable(application,R.drawable.image)!!
        }
    }
}