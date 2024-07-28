package com.example.destination.data.model

data class Destination(
    val activities: List<String>,
    val bestTimeToVisit: String,
    val continent: String,
    val country: String,
    val currency: String,
    val description: String,
    val id: Int,
    val image: String,
    val language: String,
    val localDishes: List<String>,
    val name: String,
    val population: String,
    val topAttractions: List<String>
)