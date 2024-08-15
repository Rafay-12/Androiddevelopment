package com.example.composeapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.R
import com.example.composeapp.ui.model.Item
import com.example.composeapp.ui.screens.lazycolumnscreen.LazyColumnScreen
import com.example.composeapp.ui.screens.lazygridscreen.LazyGridScreen
import com.example.composeapp.ui.screens.staggerdgridscreen.LazyStagGrid
import com.example.composeapp.ui.screens.welcome.WelcomeScreen

@Composable
fun NavController() {
    val itemList = listOf(
            Item("Duck", R.drawable.duck),
            Item("Cat", R.drawable.cat),
            Item("Lion", R.drawable.lion) ,
            Item("Duck", R.drawable.duck),
            Item("Cat", R.drawable.cat),
            Item("Lion", R.drawable.lion) ,
            Item("Duck", R.drawable.duck),
            Item("Cat", R.drawable.cat),
            Item("Lion", R.drawable.lion) ,
            Item("Duck", R.drawable.duck),
            Item("Cat", R.drawable.cat),
            Item("Lion", R.drawable.lion),
            Item("Duck", R.drawable.duck),
            Item("Cat", R.drawable.cat),
            Item("Lion", R.drawable.lion) ,
            Item("Duck", R.drawable.duck),
            Item("Cat", R.drawable.cat),
            Item("Lion", R.drawable.lion) ,
            Item("Duck", R.drawable.duck),
            Item("Cat", R.drawable.cat),
            Item("Lion", R.drawable.lion) ,
            Item("Duck", R.drawable.duck),
            Item("Cat", R.drawable.cat),
            Item("Lion", R.drawable.lion),
        Item("Duck", R.drawable.duck),
        Item("Cat", R.drawable.cat),
        Item("Lion", R.drawable.lion),
        Item("Duck", R.drawable.duck),
        Item("Cat", R.drawable.cat),
        Item("Lion", R.drawable.lion) ,
        Item("Duck", R.drawable.duck),
        Item("Cat", R.drawable.cat),
        Item("Lion", R.drawable.lion) ,
        Item("Duck", R.drawable.duck),
        Item("Cat", R.drawable.cat),
        Item("Lion", R.drawable.lion) ,
        Item("Duck", R.drawable.duck),
        Item("Cat", R.drawable.cat),
        Item("Lion", R.drawable.lion)
    )
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = "home_screen"
    ){
        composable("home_screen"){
            WelcomeScreen(navHostController = navHostController)
        }

        composable("Lazy_Column"){
            LazyColumnScreen(itemsList = itemList)
        }

        composable("Lazy_Grid"){
            LazyGridScreen(itemsList = itemList)
        }

        composable("Stagger_Screen"){
            LazyStagGrid(item = itemList)
        }
    }
}