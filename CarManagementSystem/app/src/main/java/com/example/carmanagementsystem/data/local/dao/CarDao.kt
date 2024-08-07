package com.example.carmanagementsystem.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.carmanagementsystem.data.local.entities.Car

@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCar(car: Car)

    @Query("Select * from Car_table")
    suspend fun getAllCars(): List<Car>

    @Query("Select * from Car_table where model = :carModel")
    suspend fun getCarsByModel(carModel: String): List<Car>

}