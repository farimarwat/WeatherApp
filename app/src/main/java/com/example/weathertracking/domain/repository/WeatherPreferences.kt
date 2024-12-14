package com.example.weathertracking.domain.repository

import kotlinx.coroutines.flow.Flow

interface WeatherPreferences {
    suspend fun saveActiveWeatherId(id: Int)
    suspend fun getActiveWeatherId(): Flow<Int>
}
