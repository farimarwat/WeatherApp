package com.example.weathertracking.data.remote

import com.example.weathertracking.domain.model.SearchResponse
import com.example.weathertracking.domain.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("search.json")
    suspend fun searchLocation(
        @Query("key") key: String,
        @Query("q") query: String
    ): List<SearchResponse>

    @GET("current.json")
    suspend fun getCurrent(
        @Query("key") key: String,
        @Query("q") query: String
    ):WeatherResponse
}