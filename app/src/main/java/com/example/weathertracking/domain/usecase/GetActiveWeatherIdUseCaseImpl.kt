package com.example.weathertracking.domain.usecase

import com.example.weathertracking.domain.repository.WeatherPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActiveWeatherIdUseCaseImpl @Inject constructor(
    private val weatherPreferences: WeatherPreferences
):GetActiveWeatherIdUseCase {
    override suspend fun invoke(): Flow<Int> {
        return weatherPreferences.getActiveWeatherId()
    }
}