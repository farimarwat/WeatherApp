package com.example.weathertracking.di

import com.example.weathertracking.domain.repository.WeatherPreferences
import com.example.weathertracking.domain.repository.WeatherRepository
import com.example.weathertracking.domain.usecase.GetActiveWeatherIdUseCase
import com.example.weathertracking.domain.usecase.GetActiveWeatherIdUseCaseImpl
import com.example.weathertracking.domain.usecase.GetWeatherUseCase
import com.example.weathertracking.domain.usecase.GetWeatherUseCaseImpl
import com.example.weathertracking.domain.usecase.QueryWeatherUseCase
import com.example.weathertracking.domain.usecase.QueryWeatherUseCaseImpl
import com.example.weathertracking.domain.usecase.SaveActiveWeatherIdUseCase
import com.example.weathertracking.domain.usecase.SaveActiveWeatherIdUseCaseImpl
import com.example.weathertracking.domain.usecase.SaveWeatherUseCase
import com.example.weathertracking.domain.usecase.SaveWeatherUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providesQueryWeatherUseCase(repository: WeatherRepository):QueryWeatherUseCase{
        return QueryWeatherUseCaseImpl(repository)
    }
    @Singleton
    @Provides
    fun providesSaveWeatherUseCase(repository: WeatherRepository):SaveWeatherUseCase{
        return SaveWeatherUseCaseImpl(repository)
    }
    @Singleton
    @Provides
    fun providesGetWeatherUseCase(repository: WeatherRepository):GetWeatherUseCase{
        return GetWeatherUseCaseImpl(repository)
    }
    @Singleton
    @Provides
    fun providesSaveActiveWeatherIdUseCase(weatherPreferences: WeatherPreferences):SaveActiveWeatherIdUseCase{
        return SaveActiveWeatherIdUseCaseImpl(weatherPreferences)
    }
    @Singleton
    @Provides
    fun providesGetActiveWeatherIdUseCase(weatherPreferences: WeatherPreferences):GetActiveWeatherIdUseCase{
        return GetActiveWeatherIdUseCaseImpl(weatherPreferences)
    }
}