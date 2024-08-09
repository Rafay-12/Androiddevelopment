package com.ffan.roomdatabaseapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ffan.roomdatabaseapp.R
import com.ffan.roomdatabaseapp.data.adapter.CarAdapter
import com.ffan.roomdatabaseapp.data.local.entities.Car
import com.ffan.roomdatabaseapp.ui.viewmodel.CarViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var carAdapter: CarAdapter
    private lateinit var searchBar: SearchView
    private var carList: List<Car> = listOf()
    private var filteredCarList: MutableList<Car> = mutableListOf()
    private val carViewModel: CarViewModel by viewModels()

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
        recyclerViewInit()
        setupSearchView()
    }

    private fun initUi(){
        recyclerView = findViewById(R.id.recyclerView)
        searchBar = findViewById(R.id.search_bar)
    }

    private fun setupSearchView() {
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText.orEmpty())
                return true
            }
        })
    }

    private fun recyclerViewInit(){
        carList = intent.getParcelableArrayListExtra("car_list") ?: emptyList()
        filteredCarList.addAll(carList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        carAdapter = CarAdapter(filteredCarList,
            onEditClick = { car ->
                edit(car)
            },
            onDeleteClick = { car ->
                delete(car)
            }
        )
        recyclerView.adapter = carAdapter
    }


    private fun filter(query: String) {
        filteredCarList.clear()
        if (query.isEmpty()) {
            filteredCarList.addAll(carList)
        } else {
            carList.forEach { car ->
                if (car.name.contains(query, ignoreCase = true)) {
                    filteredCarList.add(car)
                }
            }
        }
        carAdapter.notifyDataSetChanged()
    }

    private fun edit(car: Car){
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("car_name", car.name)
        intent.putExtra("company_name", car.company)
        intent.putExtra("type",car.type)
        intent.putExtra("model",car.model)
        intent.putExtra("id",car.id)
        startActivity(intent)
    }

    private fun delete(car: Car){
        AlertDialog.Builder(this)
            .setTitle("Delete Car")
            .setMessage("Are you sure you want to delete ${car.name}?")
            .setPositiveButton("Yes") { _, _ ->
                carViewModel.deleteCar(car)
                Toast.makeText(this, "Car deleted successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
            .setNegativeButton("No", null)
            .show()
    }
}