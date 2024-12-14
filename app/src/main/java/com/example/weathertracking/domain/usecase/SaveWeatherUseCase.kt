package com.example.weathertracking.domain.usecase

import com.example.weathertracking.data.local.model.WeatherEntity

interface SaveWeatherUseCase {
    operator suspend fun invoke(weatherEntity: WeatherEntity)
}