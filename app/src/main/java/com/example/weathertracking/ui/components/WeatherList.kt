package com.example.weathertracking.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weathertracking.domain.model.WeatherModel

@Composable
fun WeatherList(list: Set<WeatherModel>, onItemClicked:(WeatherModel)->Unit={}){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        LazyColumn {
            items(list.toList()){item ->
                WeatherItem(item){
                    onItemClicked(it)
                }
            }
        }
    }
}