package com.example.mvvmsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.api.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesListViewModel : ViewModel() {
    private lateinit var moviesData: MutableLiveData<List<Result>>

    /**
     * get data in moviesData List
     */
    fun getMoviesListing(): MutableLiveData<List<Result>> {
        if (!::moviesData.isInitialized) {
            moviesData = MutableLiveData()
            loadMovies()
        }

        return moviesData
    }


    private fun loadMovies() {

        ApiManager.create().listMovies(
            "c59236c023ce3768409856ba0a06009a", "en-US", "popularity.desc",
            false, false, 1
        ).enqueue(object : Callback<MoviesListingDataModel> {
            override fun onFailure(call: Call<MoviesListingDataModel>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<MoviesListingDataModel>,
                response: Response<MoviesListingDataModel>
            ) {
                if (response.isSuccessful)
                    moviesData.value = response.body()?.results
            }

        })

    }

}