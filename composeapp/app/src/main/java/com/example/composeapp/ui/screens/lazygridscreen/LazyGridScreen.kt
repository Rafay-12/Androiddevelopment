package com.example.composeapp.ui.screens.lazygridscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.MainActivity
import com.example.composeapp.ui.Item
import com.example.composeapp.ui.theme.ComposeAppTheme

@Composable
fun LazyGridScreen(itemsList: List<Item>){
    PrivateLazyStagGridColumn(itemsList)
}

@Composable
private fun PrivateLazyStagGridColumn(itemsList : List<Item>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(itemsList){ item ->
            Column(item = item)
        }
    }
}

@Composable
private fun Column(item: Item){
    Column(
        modifier = Modifier
            .width(200.dp)
            .height(220.dp)
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(30.dp)),
            painter = painterResource(id = item.image),
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        Text(
            text = item.name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive
        )
    }
}

@Preview
@Composable
private fun Preview(){
    ComposeAppTheme {
        LazyGridScreen(itemsList = MainActivity.itemList)
    }
}