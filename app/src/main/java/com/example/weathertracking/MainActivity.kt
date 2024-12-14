package com.example.weathertracking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathertracking.ui.screen.HomeScreen
import com.example.weathertracking.ui.theme.WeatherTrackingTheme
import com.example.weathertracking.ui.viewmodel.HomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeScreenViewModel:HomeScreenViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            WeatherTrackingTheme(darkTheme = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val modifier = Modifier.padding(innerPadding)
                   App(modifier,homeScreenViewModel)
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier,homeScreenViewModel: HomeScreenViewModel){
    HomeScreen(modifier,homeScreenViewModel)
}

