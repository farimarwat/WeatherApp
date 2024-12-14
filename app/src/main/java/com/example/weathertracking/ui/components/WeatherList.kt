package com.example.weathertracking.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.weathertracking.domain.model.WeatherModel

@Composable
fun WeatherList(list: Set<WeatherModel>, onItemClicked:(WeatherModel)->Unit={}){
    LazyColumn {
        items(list.toList()){item ->
            WeatherItem(item){
                onItemClicked(it)
            }
        }
    }
}