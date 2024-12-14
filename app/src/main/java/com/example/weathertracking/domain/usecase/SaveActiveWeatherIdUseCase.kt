package com.example.weathertracking.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SaveActiveWeatherIdUseCase {
    operator suspend fun invoke(id:Int)
}