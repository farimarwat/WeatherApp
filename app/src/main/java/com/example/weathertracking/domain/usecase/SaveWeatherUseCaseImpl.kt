package com.example.weathertracking.domain.usecase

import com.example.weathertracking.data.local.model.WeatherEntity
import com.example.weathertracking.domain.repository.WeatherRepository
import javax.inject.Inject

class SaveWeatherUseCaseImpl @Inject constructor(
    private val repository: WeatherRepository
):SaveWeatherUseCase {
    override suspend fun invoke(weatherEntity: WeatherEntity) {
        repository.saveWeather(weatherEntity)
    }
}