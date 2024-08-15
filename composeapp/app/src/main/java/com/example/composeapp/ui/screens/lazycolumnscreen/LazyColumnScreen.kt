package com.example.composeapp.ui.screens.lazycolumnscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.model.Item

@Composable
fun LazyColumnScreen(itemsList: List<Item>){
    PrivateLazyColumn(itemsList)
}

@Composable
private fun PrivateLazyColumn(itemsList : List<Item>){
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        items(itemsList){ item ->
            Spacer(modifier = Modifier.height(8.dp))
            Column(item)
        }
    }
}

@Composable
private fun Column(item: Item){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(30.dp)),
            painter = painterResource(id = item.image),
            contentDescription = item.name,
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = item.name,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp
        )
    }
}