package com.example.daggerdemokotlin.ui.postfragment

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Post (

    var userId:Int? = null,

    var id:Int? = null,

    var title: String? = null,

    var body: String? = null


)