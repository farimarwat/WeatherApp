package com.example.weathertracking.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetActiveWeatherIdUseCase {
    operator suspend fun invoke():Flow<Int>
}