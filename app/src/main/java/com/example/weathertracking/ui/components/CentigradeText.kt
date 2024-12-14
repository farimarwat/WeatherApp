package com.example.weathertracking.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun CentigradeText(temperature: Int) {
    Text(
        buildAnnotatedString {
            append("$temperature")
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    baselineShift = BaselineShift.Superscript
                )
            ) {
                append("°")
            }
            append("C")
        },
        style = MaterialTheme.typography.titleLarge
    )
}

