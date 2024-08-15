package com.example.composeapp.ui.model

import androidx.annotation.DrawableRes

data class Item(val name: String,
                @DrawableRes val image: Int)