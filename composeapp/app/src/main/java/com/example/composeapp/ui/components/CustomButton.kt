package com.example.composeapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

@Composable
fun CustomButton(
    backgroundColor: Color,
    text : String,
    textColor: Color,
    modifier: Modifier = Modifier,
    onClick : () -> Unit
){
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(12.dp), // Rounded corners
        border = BorderStroke(2.dp, Color.White)
    ) {
        Text(
            text = text,
            color = textColor
        )
    }
}

@Preview
@Composable
fun PreviewCustomButton(){
    ComposeAppTheme {
        CustomButton(
            backgroundColor = Color.Red,
            text = "Press Me",
            textColor = Color.Black)
        {
            print("I am clicked")
        }
    }
}