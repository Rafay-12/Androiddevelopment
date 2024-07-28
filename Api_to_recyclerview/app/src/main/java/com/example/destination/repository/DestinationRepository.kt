package com.example.destination.repository

import com.example.destination.data.model.Destination
import com.example.destination.data.network.ApiService
import com.example.destination.data.network.DestinationAPIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DestinationRepository {

    private val apiService: ApiService = DestinationAPIClient.instance

    fun getDestinations(onResult: (List<Destination>?) -> Unit, onError: (Throwable) -> Unit) {
        val call = apiService.getDestinations()

        call.enqueue(object : Callback<List<Destination>> {
            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else {
                    onError(Throwable(response.errorBody()?.string()))
                }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                onError(t)
            }
        })
    }
}