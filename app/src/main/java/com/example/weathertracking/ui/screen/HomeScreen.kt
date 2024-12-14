package com.example.weathertracking.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weathertracking.R
import com.example.weathertracking.ui.components.WeatherList
import com.example.weathertracking.ui.viewmodel.HomeScreenViewModel
import kotlinx.coroutines.flow.toList


@Composable
fun HomeScreen(modifier:Modifier,homeScreenViewModel: HomeScreenViewModel){
    Box(
        modifier = Modifier
            .then(modifier)
    ) {
        val listWeather by homeScreenViewModel.listWeather.collectAsStateWithLifecycle()
        if(listWeather.isNotEmpty()){
            WeatherList(listWeather){

            }
        }
        var query by remember { mutableStateOf("") }

       Column {
           TextField(
               modifier = Modifier
                   .clip(RoundedCornerShape(16.dp))
                   .background(MaterialTheme.colorScheme.primaryContainer),
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
           )
       }
    }

}
