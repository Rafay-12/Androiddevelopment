package com.example.destination.repository

import android.content.Context
import android.util.Log
import com.example.destination.data.model.Destination
import com.example.destination.data.network.ApiService
import com.example.destination.data.network.DestinationAPIClient
import com.example.destination.data.preferences.DataStoreManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class DestinationRepository(private val context: Context) {

    private val apiService: ApiService = DestinationAPIClient.instance
    private val destinationsKey = DataStoreManager.getStringKey("Destinations")
    private val gson = Gson()

    suspend fun getDestinations(): List<Destination> = suspendCoroutine { continuation ->
        CoroutineScope(Dispatchers.IO).launch {
            try {
                // First, try to fetch data locally
                val localData = fetchLocally()
                if (localData != null) {
                    Log.d("DestinationRepository", "Fetched from local: ${localData.size} destinations")
                    continuation.resume(localData)
                } else {
                    // If no local data, fetch from API
                    fetchDestinationsFromApi(
                        onResult = { destinations ->
                            continuation.resume(destinations ?: emptyList())
                        },
                        onError = { error ->
                            continuation.resumeWithException(error)
                        }
                    )
                }
            } catch (e: Exception) {
                continuation.resumeWithException(e)
            }
        }
    }

    private fun fetchLocally(): List<Destination>? {
        val savedDestinationsJson = DataStoreManager.getData(context, destinationsKey)
        return if (!savedDestinationsJson.isNullOrEmpty()) {
            Log.d("DestinationRepository", "Local data found")
            deserializeDestinations(savedDestinationsJson)
        } else {
            Log.d("DestinationRepository", "No local data found")
            null
        }
    }

    private fun fetchDestinationsFromApi(onResult: (List<Destination>?) -> Unit, onError: (Throwable) -> Unit) {
        val call = apiService.getDestinations()

        call.enqueue(object : Callback<List<Destination>> {
            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                if (response.isSuccessful) {
                    val destinations = response.body()
                    // Save the fetched Destination data in DataStore
                    Log.d("DestinationRepository", "Fetched from API: ${destinations?.size} destinations")
                    CoroutineScope(Dispatchers.IO).launch {
                        val destinationsJson = serializeDestinations(destinations)
                        DataStoreManager.saveData(context, destinationsKey, destinationsJson)
                    }
                    onResult(destinations)
                } else {
                    Log.e("DestinationRepository", "API error: ${response.errorBody()?.string()}")
                    onError(Throwable(response.errorBody()?.string()))
                }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                Log.e("DestinationRepository", "API call failed: ${t.message}")
                onError(t)
            }
        })
    }

    private fun serializeDestinations(destinations: List<Destination>?): String {
        // Serialize the list of Destinations to JSON
        return this.gson.toJson(destinations)
    }

    private fun deserializeDestinations(data: String): List<Destination> {
        // Deserialize the JSON string to a list of Destinations
        return this.gson.fromJson(data, object : TypeToken<List<Destination>>() {}.type)
    }
}