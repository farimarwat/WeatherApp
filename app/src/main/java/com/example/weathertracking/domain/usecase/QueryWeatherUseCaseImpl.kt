package com.example.weathertracking.domain.usecase

import com.example.weathertracking.domain.model.WeatherModel
import com.example.weathertracking.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueryWeatherUseCaseImpl @Inject constructor (
    private val repository: WeatherRepository
):QueryWeatherUseCase {
    override suspend fun invoke(query: String): Flow<WeatherModel> {
        return repository.queryWeather(query)
    }
}