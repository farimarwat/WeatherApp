package com.example.weathertracking.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.weathertracking.domain.model.WeatherModel

@Composable
fun WeatherDetailsItem(weatherModel: WeatherModel){
    Column {
        AsyncImage(
            modifier = Modifier
                .size(127.dp),
            model = weatherModel.getCompleteUrlForIcon(),
            contentDescription = weatherModel.cityName
        )
        Text(
            text = weatherModel.cityName,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        CentigradeText(weatherModel.temperatureCelsius.toInt())
    }
}

@Composable
fun SubItem(weatherModel: WeatherModel){

}