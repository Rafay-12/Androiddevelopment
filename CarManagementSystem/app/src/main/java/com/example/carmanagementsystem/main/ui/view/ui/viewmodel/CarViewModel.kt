package com.example.carmanagementsystem.main.ui.view.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carmanagementsystem.main.ui.view.data.local.entities.Car
import com.example.carmanagementsystem.main.ui.view.data.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(
    private val carRepository: CarRepository
) : ViewModel() {

    fun insertCar(car: Car) {
        viewModelScope.launch {
            carRepository.insertCar(car)
        }
    }

    fun getAllCars(): List<Car> {
        var carsList= emptyList<Car>()
        viewModelScope.launch {
            val cars = carRepository.getAllCars()
            carsList=cars

            // Do something with the users
        }
        return carsList
    }
}