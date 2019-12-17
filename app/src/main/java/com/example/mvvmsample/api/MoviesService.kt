package com.example.mvvmsample.api

import com.example.mvvmsample.MoviesListingDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesService {

    @GET("discover/movie")
    fun listMovies(
        @Query("api_key") apiKey: String, @Query("language") language: String,
        @Query("sort_by") sortBy: String, @Query("include_adult") includeAdult: Boolean,
        @Query("include_video") includeVideo: Boolean, @Query("page") page: Int
    )
            : Call<MoviesListingDataModel>
}