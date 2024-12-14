package com.example.weathertracking.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weathertracking.domain.model.WeatherModel

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cityName: String,
    val temperatureCelsius: Double,
    val weatherCondition: String,
    val iconUrl: String,
    val humidity: Int,
    val uvIndex: Double
) {
    fun toWeatherModel(): WeatherModel {
        return WeatherModel(
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