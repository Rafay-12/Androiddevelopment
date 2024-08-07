package com.ffan.roomdatabaseapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ffan.roomdatabaseapp.data.local.entities.Car

@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCar(car: Car)

    @Query("SELECT * FROM cars")
    suspend fun getAllCars(): List<Car>

      //resolve this issue
//    @Query("SELECT * FROM users WHERE ......")
//    suspend fun getUserByName(name: String): List<User>
}