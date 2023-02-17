package com.example.littlelemon.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.Typography

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItem(title: String, description: String, price: Double, image: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (){
            Text(
                text = title,
                style = Typography.subtitle1
            )
            Text(
                text = description,
                maxLines = 3,
                style = Typography.body2,
                modifier = Modifier
                    .width(250.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "$ $price",
                style = Typography.body2,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.weight(1f))
//        Image(
//            painter = painterResource(id = R.drawable.hero_image),
//            contentDescription = "restaurant photo",
//            modifier = Modifier
//                .size(80.dp),
//            contentScale = ContentScale.FillWidth
//        )
        GlideImage(
            model = image,
            contentDescription = title,
            modifier = Modifier
                .size(80.dp),
            contentScale = ContentScale.Crop
        )
    }

}

@Preview
@Composable
fun MenuItemPreview() {
    MenuItem(
        "Bruschetta",
        "Oven-baked bruschetta stuffed with tomatoes and herbs.",
        10.0,
        "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/bruschetta.jpg?raw=true"
    )
}