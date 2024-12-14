package com.example.weathertracking.data.repository

import android.content.SharedPreferences
import com.example.weathertracking.domain.repository.WeatherPreferences

class WeatherPreferencesImpl(
    private val sharedPreferences: SharedPreferences
) : WeatherPreferences {

    companion object {
        private const val ACTIVE_WEATHER_ID = "active_weather_id"
    }

    override fun saveActiveWeatherId(id: Int) {
        sharedPreferences.edit().putInt(ACTIVE_WEATHER_ID, id).apply()
    }

    override fun getActiveWeatherId(): Int {
        return sharedPreferences.getInt(ACTIVE_WEATHER_ID, -1) // -1 as default value if not set
    }
}
