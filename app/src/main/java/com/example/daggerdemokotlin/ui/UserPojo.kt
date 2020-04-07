package com.example.daggerdemokotlin.ui


data class Address(


    var street: String? = null,

    var suite: String? = null,

    var city: String? = null,

    var zipcode: String? = null,

    var geo: Geo? = null

)

data class Geo(

    var lat: String? = null,

    var lng: String? = null
)

data class Users(

    var id: Int? = null,

    var name: String? = null,

    var username: String? = null,

    var email: String? = null,

    var address: Address? = null,

    var phone: String? = null,

    var website: String? = null,

    var company: Company? = null
)


data class Company(


    var name: String? = null,

    var catchPhrase: String? = null,

    var bs: String? = null

)