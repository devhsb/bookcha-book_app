package com.hasib.bookcha.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.hasib.bookcha.R

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 18.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 15.sp,
    )

)