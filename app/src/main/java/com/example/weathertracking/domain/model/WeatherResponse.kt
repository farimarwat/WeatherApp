package com.example.weathertracking.domain.model

data class WeatherResponse(
    val location: Location,
    val current: CurrentWeather
) {
    fun toWeatherModel():WeatherModel{
        return WeatherModel(
            cityName = location.name,
            temperatureCelsius = current.temp_c,
            weatherCondition = current.condition.text,
            iconUrl = current.condition.icon,
            humidity = current.humidity,
            uvIndex = current.uv
        )
    }
}