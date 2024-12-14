package com.example.weathertracking.domain.usecase

import com.example.weathertracking.domain.repository.WeatherPreferences
import javax.inject.Inject

class SaveActiveWeatherIdUseCaseImpl @Inject constructor(
    private val weatherPreferences: WeatherPreferences
):SaveActiveWeatherIdUseCase {
    override suspend fun invoke(id: Int){
        return weatherPreferences.saveActiveWeatherId(id)
    }
}