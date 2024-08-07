package com.example.carmanagementsystem.main.ui.view.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.carmanagementsystem.R
import com.example.carmanagementsystem.main.ui.view.data.local.entities.Car
import com.example.carmanagementsystem.main.ui.view.ui.viewmodel.CarViewModel

class MainActivity : AppCompatActivity() {
    private val carViewModel: CarViewModel by viewModels()
    //private val studentViewModel: StudentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        carViewModel.insertCar(Car(name="Classic",make="KIA",model="2001",price="500000"))

        var cars=carViewModel.getAllCars()
        cars.forEach { car ->
            Log.d("MainActivity","name=${car.name}, make= ${car.make}, model=${car.model}, price=${car.price}")
        }

    }
}