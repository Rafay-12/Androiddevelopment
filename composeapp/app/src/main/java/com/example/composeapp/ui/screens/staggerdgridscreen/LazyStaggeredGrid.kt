package com.example.composeapp.ui.screens.staggerdgridscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.MainActivity
import com.example.composeapp.ui.Item
import com.example.composeapp.ui.theme.ComposeAppTheme
import kotlin.random.Random

@Composable
fun LazyStagGrid(item: List<Item>){
    PrivateGrid(item = item)
}

@Composable
private fun PrivateGrid(item: List<Item>){
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(item){ item ->
            val randomHeight =  Random.nextInt(100, 200).dp
            Column(item = item, size = randomHeight)
        }
    }
}

@Composable
private fun Column(item: Item, size: Dp){
    androidx.compose.foundation.layout.Column(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(size)
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
        Surface(modifier = Modifier
            .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyStagGrid(item = MainActivity.itemList)
        }

    }
}