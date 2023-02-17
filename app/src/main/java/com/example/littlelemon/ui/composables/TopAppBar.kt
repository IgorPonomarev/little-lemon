package com.example.littlelemon.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R

@Composable
fun CustomTopAppBar(
    title: String = "Little Lemon",
    profileIconClick: () -> Unit
) {

    TopAppBar(
        title = {
            Text(text = title)
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp,
        actions = { TopAppBarProfileButton(profileIconClick)},
    )
}

@Composable
fun TopAppBarProfileButton(
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "profile icon",
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier
                .padding(8.dp)
                .size(28.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}


@Preview
@Composable
fun Preview1() {
    CustomTopAppBar {
        
    }
}