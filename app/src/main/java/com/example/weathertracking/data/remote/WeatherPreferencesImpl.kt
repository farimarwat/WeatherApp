package com.example.weathertracking.data.remote

import android.content.Context
import android.preference.PreferenceDataStore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.weathertracking.domain.repository.WeatherPreferences
import com.example.weathertracking.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class WeatherPreferencesImpl(
    private val context:Context
): WeatherPreferences {
    val Context.datastore:DataStore<Preferences> by preferencesDataStore(name = Constants.APP_PREFERENCES)
    override suspend fun saveActiveWeatherId(id: Int) {
        context.datastore.edit { preferences ->
            preferences[Keys.COUNTRY_ID] = id
        }
    }

    override suspend fun getActiveWeatherId(): Flow<Int> {
        return context.datastore.data.map { preferences ->
            preferences[Keys.COUNTRY_ID] ?: 0
        }
    }

    object Keys{
        val COUNTRY_ID = intPreferencesKey("country_id")
    }

}