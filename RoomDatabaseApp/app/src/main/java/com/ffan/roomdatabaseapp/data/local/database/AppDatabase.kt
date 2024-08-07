package com.ffan.roomdatabaseapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ffan.roomdatabaseapp.data.local.dao.CarDao
import com.ffan.roomdatabaseapp.data.local.entities.Car

@Database(entities = [Car::class] , version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun carDao(): CarDao
}