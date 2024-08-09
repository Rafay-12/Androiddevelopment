package com.ffan.roomdatabaseapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ffan.roomdatabaseapp.R
import com.ffan.roomdatabaseapp.data.local.entities.Car
import com.ffan.roomdatabaseapp.ui.viewmodel.CarViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val carViewModel: CarViewModel by viewModels()
    private lateinit var submit: Button
    private lateinit var display: Button
    private lateinit var name: EditText
    private lateinit var company: EditText
    private lateinit var type: EditText
    private lateinit var model: EditText
    private var carList: List<Car> = emptyList()

    private var carId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        observeCars()
        initUi()
        setListeners()
        edit()
    }

    private fun observeCars() {
        carViewModel.allCars.observe(this) { cars ->
            carList = cars
        }
    }

    private fun edit(){
        val carName = intent.getStringExtra("car_name")
        name.setText(carName ?: "")
        val companyName = intent.getStringExtra("company_name")
        company.setText(companyName ?: "")
        val typeName = intent.getStringExtra("type")
        type.setText(typeName ?: "")
        val modelName = intent.getStringExtra("model")
        model.setText(modelName ?: "")
        carId = intent.getIntExtra("id",0).takeIf { it != 0 }
    }

    private fun initUi() {
        submit = findViewById(R.id.submitBtn)
        display = findViewById(R.id.displayBtn)
        name = findViewById(R.id.name)
        company = findViewById(R.id.companyName)
        type = findViewById(R.id.type)
        model = findViewById(R.id.model)
    }

    private fun setListeners() {
        submit.setOnClickListener {
            val (name, company, type, model) = listOf(
                name,
                company,
                type,
                model
            ).map { it.text.toString() }

            if (listOf(name, company, type, model).all { it.isNotEmpty() }) {
                if (carId != null) {
                    // If carId is not null, we're editing an existing car
                    carViewModel.updateCar(
                        Car(
                            id = carId!!,
                            name = name,
                            company = company,
                            type = type,
                            model = model
                        )
                    )
                    Toast.makeText(this, "Car updated successfully!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    // If carId is null, we're adding a new car
                    carViewModel.insertCar(
                        Car(
                            name = name,
                            company = company,
                            type = type,
                            model = model
                        )
                    )
                    Toast.makeText(this, "Car added successfully!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }

        display.setOnClickListener {
            if (carList.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putParcelableArrayListExtra("car_list", ArrayList(carList))
                startActivity(intent)
            } else {
                Log.d("MainActivity", "Car list is empty or null")
            }
        }
    }
}