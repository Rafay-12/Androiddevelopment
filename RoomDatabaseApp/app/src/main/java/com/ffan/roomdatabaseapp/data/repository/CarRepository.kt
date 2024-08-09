package com.ffan.roomdatabaseapp.data.repository

import androidx.lifecycle.LiveData
import com.ffan.roomdatabaseapp.data.local.dao.CarDao
import com.ffan.roomdatabaseapp.data.local.entities.Car


class CarRepository(private val carDao: CarDao) {

    suspend fun insertCar(car: Car) {
        carDao.insertCar(car)
    }

    fun getAllCars(): LiveData<List<Car>> {
        return carDao.getAllCars()
    }

    suspend fun deleteCar(car: Car){
        carDao.deleteCar(car)
    }

    suspend fun updateCar(car: Car){
        carDao.updateCar(car)
    }
}