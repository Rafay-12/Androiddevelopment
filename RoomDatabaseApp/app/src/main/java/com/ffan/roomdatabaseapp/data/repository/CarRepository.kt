package com.ffan.roomdatabaseapp.data.repository

import com.ffan.roomdatabaseapp.data.local.dao.CarDao
import com.ffan.roomdatabaseapp.data.local.entities.Car


class CarRepository(private val carDao: CarDao) {

    suspend fun insertCar(car: Car) {
        carDao.insertCar(car)
    }

    suspend fun getAllCars(): List<Car> {
        return carDao.getAllCars()
    }
}