package com.example.weathertracking.domain.usecase

import com.example.weathertracking.data.local.model.WeatherEntity
import com.example.weathertracking.domain.model.WeatherModel

interface GetWeatherUseCase {
    operator suspend fun invoke(id:Int):WeatherModel
}