package com.example.weathertracking.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weathertracking.R
import com.example.weathertracking.ui.components.CurrentWeatherStatus
import com.example.weathertracking.ui.components.WeatherList
import com.example.weathertracking.ui.viewmodel.HomeScreenViewModel
import kotlinx.coroutines.flow.toList


@Composable
fun HomeScreen(modifier:Modifier,homeScreenViewModel: HomeScreenViewModel){
    LaunchedEffect(Unit) {
        homeScreenViewModel.getActiveWeather()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .then(modifier)
            .padding(16.dp)
    ) {
        val listWeather by homeScreenViewModel.listWeather.collectAsStateWithLifecycle()
        var query by remember { mutableStateOf("") }

        Column (
            modifier = Modifier.fillMaxSize()
        ){
            val keyboardController = LocalSoftwareKeyboardController.current
            //Search bar
            TextField(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .fillMaxWidth(),
                value = query,
                onValueChange = {
                    query = it
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions (
                    onSearch = {
                        homeScreenViewModel.queryWeather(query)
                        keyboardController?.hide()
                    }
                ),
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable { homeScreenViewModel.queryWeather(query) },
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ){

                CurrentWeatherStatus(homeScreenViewModel.mActiveWeather)
                //List
                if(listWeather.isNotEmpty()){
                    WeatherList(listWeather){
                        homeScreenViewModel.saveWeather(it)
                        homeScreenViewModel.clearQuariedItems()
                        keyboardController?.hide()
                    }
                }
            }
        }
    }

}
