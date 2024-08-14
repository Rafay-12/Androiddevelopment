package com.example.composeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme

@Composable
fun CustomTextField(
    backgroundColor: Color,
    hintText: String,
    textColor: Color
) {
    // State to hold the text value
    var textState = remember { TextFieldValue() }

    // Custom OutlinedTextField with your custom parameters
    OutlinedTextField(
        value = textState,
        onValueChange = { newText -> textState = newText },
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(8.dp),
        placeholder = {
            Text(text = hintText, color = textColor, fontSize = 20.sp, fontFamily = FontFamily.Cursive)
        },
        textStyle = androidx.compose.ui.text.TextStyle(color = textColor),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Black,
            focusedBorderColor = Color.Blue
        )
    )
}

@Preview
@Composable
fun PreviewCustomTextField(){
    ComposeAppTheme {
        CustomTextField(
            backgroundColor = Color.LightGray,
            hintText = "Enter Your Email",
            textColor = Color.Black
        )
    }
}