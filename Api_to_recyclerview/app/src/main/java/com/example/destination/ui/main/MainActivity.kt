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
import com.example.destination.repository.DestinationRepository

class MainActivity : AppCompatActivity() {
    private val destinationRepository = DestinationRepository()
    private lateinit var itemRecyclerViewAdapter: RecyclerViewAdapter
    private lateinit var itemRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fetchDestinations()
    }

    private fun fetchDestinations() {
        destinationRepository.getDestinations(
            onResult ={
              destinations ->
                destinations?.let {
                    itemRecyclerViewAdapter = RecyclerViewAdapter(it)
                    itemRecyclerView = findViewById(R.id.recyclerView)
                    itemRecyclerView.layoutManager = LinearLayoutManager(this)
                    itemRecyclerView.adapter = itemRecyclerViewAdapter
                }
            },
            onError = { error ->
                Log.e("MainActivity", "Error: ${error.message}")
            }
        )
    }
}