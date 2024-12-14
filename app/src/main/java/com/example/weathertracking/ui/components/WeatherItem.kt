package com.example.weathertracking.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.weathertracking.domain.model.WeatherModel

@Composable
fun WeatherItem(weatherModel: WeatherModel,onClick:(WeatherModel)->Unit = {}){
    Card {
        Row (
            modifier = Modifier
                .clickable { onClick(weatherModel) }
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth()
                .height(200.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = weatherModel.cityName,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                CentigradeText(weatherModel.temperatureCelsius.toInt())
            }
        }
        AsyncImage(
            model = weatherModel.iconUrl,
            contentDescription = weatherModel.cityName
        )
    }
}