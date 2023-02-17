package com.example.littlelemon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_regular)),
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    // Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_regular)),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
        fontWeight = FontWeight.Medium,
        fontSize = 64.sp
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.markazi_text_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp
    ),
    defaultFontFamily = FontFamily(Font(R.font.karla_regular)),
    subtitle1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_regular)),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.karla_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
)