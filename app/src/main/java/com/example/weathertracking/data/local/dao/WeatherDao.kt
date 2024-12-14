package com.example.weathertracking.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weathertracking.data.local.model.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weatherEntity: WeatherEntity)

    @Query("SELECT * FROM weather WHERE id = :id")
    fun getWeatherById(id:Int):WeatherEntity
}