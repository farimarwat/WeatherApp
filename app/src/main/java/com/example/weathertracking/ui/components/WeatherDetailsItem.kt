package com.example.weathertracking.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.weathertracking.domain.model.WeatherModel
import com.example.weathertracking.ui.theme.GrayLight
import com.example.weathertracking.ui.theme.GrayMedium

@Composable
fun WeatherDetailsItem(weatherModel: WeatherModel){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AsyncImage(
            modifier = Modifier
                .size(200.dp),
            model = weatherModel.getCompleteUrlForIcon(),
            contentDescription = weatherModel.cityName
        )
        Text(
            text = weatherModel.cityName,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        CentigradeText(weatherModel.temperatureCelsius.toInt(),MaterialTheme.typography.headlineLarge)

        Row (
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            SubItem("humidity",weatherModel.humidity.toString()+"%")
            SubItem("UV",weatherModel.uvIndex.toString())
            SubItem("Feels Like",weatherModel.feelslike_c.toInt().toString())
        }
    }
}

@Composable
fun SubItem(title:String,details:String){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            text = title,
            fontSize = 20.sp,
            color = GrayLight
        )
        Text(
            text = details,
            fontSize = 20.sp,
            color = GrayMedium
        )
    }
}