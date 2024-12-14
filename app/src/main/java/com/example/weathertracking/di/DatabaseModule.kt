package com.example.weathertracking.di

import android.content.Context
import androidx.room.Room
import com.example.weathertracking.data.local.AppDatabase
import com.example.weathertracking.data.local.dao.WeatherDao
import com.example.weathertracking.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(context: Context):AppDatabase{
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = Constants.DATABASE_NAME
        )
            .build()
    }

    @Singleton
    @Provides
    fun providesWeatherDao(database: AppDatabase):WeatherDao{
        return database.weatherDao()
    }
}