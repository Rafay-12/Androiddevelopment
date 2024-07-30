package com.example.destination.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.destination.R
import com.example.destination.data.adapter.RecyclerViewAdapter
import com.example.destination.data.model.Destination
import com.example.destination.data.preferences.PreferenceManager
import com.example.destination.repository.DestinationRepository
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private val destinationRepository = DestinationRepository()
    private lateinit var itemRecyclerViewAdapter: RecyclerViewAdapter
    private lateinit var itemRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PreferenceManager.init(this)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fetchDestinations()
    }
    
    // initialize recyclerView and adapter
    private fun adapterInit(list: List<Destination>){
        itemRecyclerView = findViewById(R.id.recyclerView)
        itemRecyclerView.layoutManager = LinearLayoutManager(this)
        itemRecyclerViewAdapter = RecyclerViewAdapter(list)
        itemRecyclerView.adapter = itemRecyclerViewAdapter
    }
    
    //fetching destinations and storing them in cache
    private fun fetchDestinations() {
        //Check if student data is already saved in SharedPreferences
        val savedDestinationsJson = PreferenceManager.get("destinations", "")
        if (!savedDestinationsJson.isNullOrEmpty()) {
            // Parse saved student data and log it
            val destinations: List<Destination> = deserializeItems(savedDestinationsJson)
            adapterInit(destinations)
        }
        else{
            destinationRepository.getDestinations(
                onResult = { destinations ->
                    destinations?.let {
                        adapterInit(it)
                    }
                    // Save the fetched student data in SharedPreferences
                    val destinationsJson = serializeItems(destinations)
                    PreferenceManager.save("destinations", destinationsJson)
                },
                onError = { error ->
                    Log.e("MainActivity", "Error: ${error.message}")
                }
            )
        }
    }

    private fun serializeItems(destinations: List<Destination>?): String {
        // Serialize the list of students to JSON
        return PreferenceManager.gson.toJson(destinations)
    }

    private fun deserializeItems(data: String): List<Destination> {
        // Deserialize the JSON string to a list of students
        return PreferenceManager.gson.fromJson(data, object : TypeToken<List<Destination>>() {}.type)
    }
}