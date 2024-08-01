package com.example.destination.data.network

import com.example.destination.data.model.Destination
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("destinations")
    fun getDestinations(): Call<List<Destination>>

    // ALL METHOD SHOULD BE MENTIONED HERE
    // PUT
    // POST
    // GET
}