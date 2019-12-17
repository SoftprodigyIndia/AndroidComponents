package com.example.mvvmsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmsample.api.MoviesListingAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MoviesListingActivity : AppCompatActivity() {

    private lateinit var moviesListViewModel: MoviesListViewModel
    private lateinit var mMoviesAdapter: MoviesListingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesListViewModel = ViewModelProviders.of(this).get(MoviesListViewModel::class.java)
        mMoviesAdapter = MoviesListingAdapter()
        rvMovies.layoutManager = LinearLayoutManager(this)
        rvMovies.adapter = mMoviesAdapter

        //observing changes in data from API
        moviesListViewModel.getMoviesListing().observe(this, Observer<List<Result>> { response ->
            mMoviesAdapter.addData(response)
        })

    }
}
