package com.example.weathertracking.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weathertracking.data.local.dao.WeatherDao
import com.example.weathertracking.data.local.model.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 10)
abstract class AppDatabase:RoomDatabase() {
    abstract fun weatherDao():WeatherDao
}