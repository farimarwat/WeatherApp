package com.example.weathertracking.data.repository

import com.example.weathertracking.data.local.dao.WeatherDao
import com.example.weathertracking.data.local.model.WeatherEntity
import com.example.weathertracking.data.remote.WeatherService
import com.example.weathertracking.domain.model.SearchResponse
import com.example.weathertracking.domain.model.WeatherModel
import com.example.weathertracking.domain.model.WeatherResponse
import com.example.weathertracking.domain.repository.WeatherRepository
import com.example.weathertracking.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDao:WeatherDao,
    private val weatherService:WeatherService
): WeatherRepository {
    override suspend fun fetchWeather(id: Int): WeatherModel {
        return weatherDao.getWeatherById(id).toWeatherModel()
    }

    override suspend fun saveWeather(weatherEntity: WeatherEntity) {
        weatherDao.insertWeather(weatherEntity)
    }

    override suspend fun queryWeather(query: String): Flow<List<WeatherModel>> = flow {
        val cities = weatherService.searchLocation(key = Constants.API_KEY, query = query)
        val weatherModels = cities.map { searchResponse ->
            val weatherResponse = weatherService.getCurrent(key = Constants.API_KEY, query = searchResponse.name)
            weatherResponse.toWeatherModel().copy(id = searchResponse.id)
        }
        emit(weatherModels)
    }



}