package com.example.destination.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.destination.R
import com.example.destination.data.adapter.RecyclerViewAdapter
import com.example.destination.viewModel.DestinationViewModel

class MainActivity : AppCompatActivity() {
    private val destinationViewModel: DestinationViewModel by viewModels()
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initUi()
    }

    private fun initUi(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        destinationViewModel.destinations.observe(this) { destinations ->
            if (destinations != null) {
                recyclerView.adapter = RecyclerViewAdapter(destinations)
                Log.d("MainActivity", "Received destinations: ${destinations.size}")
            } else {
                Log.d("MainActivity", "No destinations found")
            }
        }

        destinationViewModel.error.observe(this) { error ->
            Log.e("MainActivity", "Error: $error")
        }
    }
}

