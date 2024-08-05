package com.example.database.main.data.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.database.main.data.dao.UserDao
import com.example.database.main.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao():UserDao


    companion object{
        @Volatile
        var instance:UserDatabase? = null
        private const val DATABASE_NAME = "User_Database"
        fun getInstance(context: Context):UserDatabase?{
            if(instance == null){
                synchronized(UserDatabase::class.java){
                    if (instance == null){
                        Log.d("UserDatabase","initializing database")
                        instance = Room.databaseBuilder(context,UserDatabase::class.java, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return instance
        }
    }

}