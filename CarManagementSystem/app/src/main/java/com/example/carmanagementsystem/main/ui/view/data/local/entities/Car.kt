package com.example.carmanagementsystem.main.ui.view.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cars")
data class Car(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String,
    var make:String,
    var model: String,
    var price:String
)