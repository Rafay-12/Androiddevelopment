package com.example.carmanagementsystem.main.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carmanagementsystem.data.local.entities.Car
import com.example.carmanagementsystem.data.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor (private val carRepository: CarRepository): ViewModel() {
    private val _allCars = MutableLiveData<List<Car>>()
    val allCars: LiveData<List<Car>> get() = _allCars

    init {
        getAllCars()
    }

    fun insertCar(car: Car){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                carRepository.insertCar(car)
            }
        }
    }

    private fun getAllCars(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _allCars.postValue(carRepository.getAllCars())
            }
        }
    }
}