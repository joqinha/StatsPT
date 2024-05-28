package com.joaoferreira.statspt.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joaoferreira.ine_presentation.country_overview.CountryOverviewScreen
import com.joaoferreira.statspt.navigation.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            myCompose()
            val navController = rememberNavController()
            Scaffold(modifier = Modifier.fillMaxSize()) {
                NavHost(navController = navController, startDestination = Route.COUNTRY_OVERVIEW) {
                    composable(Route.COUNTRY_OVERVIEW) {
                        CountryOverviewScreen()
                    }
                }
            }
        }
    }
}

@Composable
private fun myCompose(myViewModel: MyViewModel = hiltViewModel()) {
    val value = myViewModel.value.collectAsState()
    Text(value.value.toString())
}