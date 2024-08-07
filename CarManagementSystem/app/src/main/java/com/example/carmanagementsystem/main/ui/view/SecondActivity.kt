package com.example.carmanagementsystem.main.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carmanagementsystem.R
import com.example.carmanagementsystem.data.adapter.CarAdapter
import com.example.carmanagementsystem.data.local.entities.Car

class SecondActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var carAdapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       initUi()
    }

    private fun initUi(){
        val carList = intent.getParcelableArrayListExtra<Car>("car_list") ?: emptyList()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        carAdapter = CarAdapter(carList)
        recyclerView.adapter = carAdapter
    }
}