package com.example.weathertracking.domain.usecase

import com.example.weathertracking.data.local.model.WeatherEntity
import com.example.weathertracking.domain.model.WeatherModel
import com.example.weathertracking.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCaseImpl @Inject constructor(
    private val repository: WeatherRepository
) :GetWeatherUseCase {
    override suspend fun invoke(id: Int): WeatherModel {
       return repository.fetchWeather(id)
    }
}