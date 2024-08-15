package com.example.composeapp.ui.screens.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.composeapp.ui.components.CustomButton


@Composable
fun WelcomeScreen(navHostController: NavHostController){
    WelcomeScreenContent(navHostController = navHostController)
}

@Composable
private fun WelcomeScreenContent(navHostController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        CustomButton(
            backgroundColor = Color.LightGray,
            text = "LazyColumn",
            textColor = Color.White
        ) {
            navHostController.navigate("Lazy_Column")
        }

        CustomButton(
            backgroundColor = Color.LightGray,
            text = "LazyGrid",
            textColor = Color.White
        ) {
            navHostController.navigate("Lazy_Grid")
        }

        CustomButton(
            backgroundColor = Color.LightGray,
            text = "StaggeredGrid",
            textColor = Color.White
        ) {
            navHostController.navigate("Stagger_Screen")
        }
    }
}
