package com.example.weathertracking.domain.repository

import com.example.weathertracking.data.local.model.WeatherEntity
import com.example.weathertracking.domain.model.SearchResponse
import com.example.weathertracking.domain.model.WeatherModel
import com.example.weathertracking.domain.model.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun fetchWeather(id:Int):WeatherModel
    suspend fun saveWeather(weatherEntity: WeatherEntity)
    suspend fun queryWeather(query:String):Flow<WeatherModel>
}