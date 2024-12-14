package com.example.weathertracking.di

import android.content.Context
import com.example.weathertracking.data.remote.WeatherPreferencesImpl
import com.example.weathertracking.domain.repository.WeatherPreferences
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
}