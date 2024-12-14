package com.example.weathertracking.domain.usecase

interface SaveActiveWeatherIdUseCase {
    operator suspend fun invoke(id: Int)
}