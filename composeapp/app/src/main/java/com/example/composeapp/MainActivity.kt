package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.composeapp.ui.Item
import com.example.composeapp.ui.screens.welcome.WelcomeScreen
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    companion object{
        val itemList = listOf(
            Item("Duck", R.drawable.duck),
            Item("Cat",R.drawable.cat),
            Item("Lion",R.drawable.lion) ,
            Item("Duck", R.drawable.duck),
            Item("Cat",R.drawable.cat),
            Item("Lion",R.drawable.lion) ,
            Item("Duck", R.drawable.duck),
            Item("Cat",R.drawable.cat),
            Item("Lion",R.drawable.lion) ,
            Item("Duck", R.drawable.duck),
            Item("Cat",R.drawable.cat),
            Item("Lion",R.drawable.lion)
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                         color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

