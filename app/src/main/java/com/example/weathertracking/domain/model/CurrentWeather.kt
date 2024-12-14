package com.example.weathertracking.domain.model

data class CurrentWeather(
    val temp_c: Double,
    val condition: WeatherCondition,
    val humidity: Int,
    val uv: Double,
    val feelslike_c:Double
)