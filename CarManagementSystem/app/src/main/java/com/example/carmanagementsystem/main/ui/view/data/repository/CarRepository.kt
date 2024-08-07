package com.example.carmanagementsystem.main.ui.view.data.repository

import com.example.carmanagementsystem.main.ui.view.data.local.dao.CarDao
import com.example.carmanagementsystem.main.ui.view.data.local.entities.Car

class CarRepository(private val carDao: CarDao) {

    suspend fun insertCar(car: Car) {
        carDao.insertCar(car)
    }

    suspend fun getAllCars(): List<Car> {
        return carDao.getAllCars()
    }
}