package com.example.weathertracking.domain.model

import com.example.weathertracking.data.local.model.WeatherEntity

data class WeatherModel(
    val id: Long = 0, // Optional id, may not be present initially.
    val cityName: String,
    val temperatureCelsius: Double,
    val weatherCondition: String,
    val iconUrl: String,
    val humidity: Int,
    val uvIndex: Double
) {
    fun toEntity(): WeatherEntity {
        return WeatherEntity(
            id = this.id,
            cityName = this.cityName,
            temperatureCelsius = this.temperatureCelsius,
            weatherCondition = this.weatherCondition,
            iconUrl = this.iconUrl,
            humidity = this.humidity,
            uvIndex = this.uvIndex
        )
    }
}