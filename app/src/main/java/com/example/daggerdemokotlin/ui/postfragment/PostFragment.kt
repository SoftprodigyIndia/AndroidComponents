package com.example.daggerdemokotlin.ui.postfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerdemokotlin.R
import com.example.daggerdemokotlin.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_post.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostFragment : DaggerFragment() {

    @Inject
    lateinit var providerfactory: ViewModelProviderFactory

    lateinit var viewPostViewModel: PostViewModel

    @Inject
    lateinit var postAdapter: PostAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_post,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setObserver()


        recyclerViewSet()


    }

    private fun recyclerViewSet() {
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViews!!.layoutManager = linearLayoutManager
        recyclerViews.adapter=postAdapter
    }

    private fun setObserver() {

        viewPostViewModel=ViewModelProvider(this,providerfactory).get(PostViewModel::class.java)

        CoroutineScope(IO).launch {
            viewPostViewModel.postCall()

        }

        viewPostViewModel.mutablePost.observe(this, Observer {
            Log.e("size",it.size.toString())
            postAdapter.addPost(it)
            postAdapter.notifyDataSetChanged()
        })
    }
}