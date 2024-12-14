package com.example.weathertracking.data.mapper

fun WeatherModel.toEntity(): WeatherEntity {
    return WeatherEntity(
        id = this.id,
        cityName = this.cityName,
        temperature = this.temperature,
        weatherCondition = this.weatherCondition,
        weatherIconUrl = this.weatherIconUrl,
        humidity = this.humidity,
        uvIndex = this.uvIndex,
        feelsLikeTemperature = this.feelsLikeTemperature
    )
}

fun WeatherEntity.toModel(): WeatherModel {
    return WeatherModel(
        id = this.id,
        cityName = this.cityName,
        temperature = this.temperature,
        weatherCondition = this.weatherCondition,
        weatherIconUrl = this.weatherIconUrl,
        humidity = this.humidity,
        uvIndex = this.uvIndex,
        feelsLikeTemperature = this.feelsLikeTemperature
    )
}
