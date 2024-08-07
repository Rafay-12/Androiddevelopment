package com.example.carmanagementsystem.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.carmanagementsystem.data.local.dao.CarDao
import com.example.carmanagementsystem.data.local.entities.Car

@Database(entities = [Car::class] , version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun carDao(): CarDao
}