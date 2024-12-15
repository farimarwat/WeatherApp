package com.example.weathertracking.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertracking.domain.model.WeatherModel
import com.example.weathertracking.domain.usecase.GetActiveWeatherIdUseCase
import com.example.weathertracking.domain.usecase.GetWeatherUseCase
import com.example.weathertracking.domain.usecase.QueryWeatherUseCase
import com.example.weathertracking.domain.usecase.SaveActiveWeatherIdUseCase
import com.example.weathertracking.domain.usecase.SaveWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val application: Application,
    private val getActiveWeatherIdUseCase: GetActiveWeatherIdUseCase,
    private val saveActiveWeatherIdUseCase: SaveActiveWeatherIdUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
    private val saveWeatherUseCase: SaveWeatherUseCase,
    private val queryWeatherUseCase: QueryWeatherUseCase
) :AndroidViewModel(application){

    private var jobQueryWeather: Job? = null
    private var jobGetActiveWeather:Job? = null
    private var jobSaveWeatherUseCase:Job? = null

    private var _listWeather:MutableStateFlow<MutableSet<WeatherModel>> = MutableStateFlow(mutableSetOf())
    val listWeather = _listWeather.asStateFlow()

    var mActiveWeather by mutableStateOf<WeatherModel?>(null)

    fun queryWeather(query: String) {
        jobQueryWeather?.cancel()
        _listWeather.value = mutableSetOf()
        jobQueryWeather = viewModelScope.launch(Dispatchers.IO) {
            queryWeatherUseCase(query).collect { weatherModel ->
                val updatedSet = _listWeather.value.toMutableSet() // Create a new mutable copy
                updatedSet.add(weatherModel) // Add the new item
                _listWeather.value = updatedSet // Assign the new instance
                Timber.i(_listWeather.value.toString())
            }
        }
    }


    fun getActiveWeather(){
        jobGetActiveWeather?.cancel()
        jobGetActiveWeather = viewModelScope.launch(Dispatchers.IO) {
            getActiveWeatherIdUseCase().collect{id ->
                Timber.i("Active Weather: ${id}")
                if(id > 0){
                    mActiveWeather = getWeatherUseCase(id)
                }
            }
        }
    }

    fun saveWeather(weatherModel: WeatherModel){
        jobSaveWeatherUseCase?.cancel()
        jobSaveWeatherUseCase = viewModelScope.launch(Dispatchers.IO) {
            saveWeatherUseCase(weatherModel.toEntity())
            saveActiveWeatherIdUseCase(weatherModel.id)
        }
    }
    fun clearQuariedItems(){
        _listWeather.value = mutableSetOf()
    }

    override fun onCleared() {
        super.onCleared()
        jobQueryWeather = null
        jobGetActiveWeather = null
    }
}