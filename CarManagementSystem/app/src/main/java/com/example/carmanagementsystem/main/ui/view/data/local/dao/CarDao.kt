package com.example.carmanagementsystem.main.ui.view.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.carmanagementsystem.main.ui.view.data.local.entities.Car

@Dao
interface CarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCar(user: Car)

    @Query("SELECT * FROM cars")
    suspend fun getAllCars(): List<Car>

//    // resolve this issue
//    @Query("SELECT * FROM cars WHERE ......")
//    suspend fun getCarByName(name: String): List<Car>
}