package com.example.weathertracking.domain.usecase

import com.example.weathertracking.domain.model.WeatherModel
import kotlinx.coroutines.flow.Flow

interface QueryWeatherUseCase {
    operator suspend fun invoke(query:String):Flow<WeatherModel>
}