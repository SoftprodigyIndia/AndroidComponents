package com.example.mvvmsample.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmsample.R
import com.example.mvvmsample.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movies_list.view.*

class MoviesListingAdapter : RecyclerView.Adapter<MoviesListingAdapter.MoviesListHolder>() {

    private var mMoviesData: ArrayList<Result> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListHolder =
        MoviesListHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies_list, parent, false))

    override fun getItemCount(): Int = mMoviesData.size

    override fun onBindViewHolder(holder: MoviesListHolder, position: Int) {
        val data = mMoviesData[position]
        Picasso.get().load(data.getPosterImage()).into(holder.imgPoster)
        holder.txtMovieName.text = data.title
    }

    //add data to list and notify changes to adapter
    fun addData(moviesData: List<Result>){
        mMoviesData.addAll(moviesData)
        notifyDataSetChanged()
    }

    class MoviesListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPoster: ImageView = itemView.imgPoster
        val txtMovieName: TextView = itemView.tvMovieName
    }
}