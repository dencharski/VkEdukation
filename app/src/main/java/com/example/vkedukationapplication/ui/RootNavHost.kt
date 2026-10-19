package com.example.vkedukationapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun RootNavHost1() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "" // Стартовый экран будет тут
    ) {
        // Здесь будем регистрировать экраны
    }

}