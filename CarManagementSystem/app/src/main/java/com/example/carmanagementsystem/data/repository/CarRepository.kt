package com.example.carmanagementsystem.data.repository

import com.example.carmanagementsystem.data.local.dao.CarDao
import com.example.carmanagementsystem.data.local.entities.Car

class CarRepository(private val carDao: CarDao) {

    suspend fun insertCar(car: Car){
        carDao.insertCar(car)
    }

    suspend fun getAllCars() : List<Car>{
        return carDao.getAllCars()
    }

    suspend fun getCarsByModel(model: String): List<Car>{
        return carDao.getCarsByModel(model)
    }
}