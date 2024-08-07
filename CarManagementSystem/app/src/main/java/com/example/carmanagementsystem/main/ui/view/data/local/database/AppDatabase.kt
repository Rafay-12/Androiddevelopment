package com.example.carmanagementsystem.main.ui.view.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.carmanagementsystem.main.ui.view.data.local.dao.CarDao
import com.example.carmanagementsystem.main.ui.view.data.local.entities.Car

@Database(entities = [Car::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao

    // ON UPDATE,,,, WHAT TO DO WHEN SCHEMA IS CHANGE
}