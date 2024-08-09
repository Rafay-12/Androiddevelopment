package com.ffan.roomdatabaseapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ffan.roomdatabaseapp.data.local.entities.Car
import com.ffan.roomdatabaseapp.data.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(
    private val carRepository: CarRepository
) : ViewModel() {
   val allCars: LiveData<List<Car>> = carRepository.getAllCars()


    fun insertCar(car: Car){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                carRepository.insertCar(car)
            }
        }
    }

    fun deleteCar(car: Car){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                carRepository.deleteCar(car)
            }
        }
    }

    fun updateCar(car:Car){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                carRepository.updateCar(car)
            }
        }
    }

}