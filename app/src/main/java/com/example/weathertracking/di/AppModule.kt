package com.example.weathertracking.di

import android.content.Context
import com.example.weathertracking.data.local.dao.WeatherDao
import com.example.weathertracking.data.remote.WeatherService
import com.example.weathertracking.data.repository.WeatherPreferencesImpl
import com.example.weathertracking.data.repository.WeatherRepositoryImpl
import com.example.weathertracking.domain.repository.WeatherPreferences
import com.example.weathertracking.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun providePreferences(context:Context):WeatherPreferences{
        return WeatherPreferencesImpl(context)
    }

    @Singleton
    @Provides
    fun providesWeatherRepository(weatherDao: WeatherDao,weatherService: WeatherService):WeatherRepository{
        return WeatherRepositoryImpl(weatherDao,weatherService)
    }
}