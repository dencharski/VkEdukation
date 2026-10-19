package com.example.vkedukationapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vkedukationapplication.ui.AppDetailsContent
import com.example.vkedukationapplication.ui.theme.VkEdukationApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEdukationApplicationTheme {
RootNavHost()
               // AppDetailsContent()
            }
        }
    }
}

@Composable
fun RootNavHost() {
    val DETAILS_DESTINATION = "details"
    val CURRENT_APP_DESTINATION = "current_app"

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DETAILS_DESTINATION, // Стартовый экран будет тут
    ) {
        composable(DETAILS_DESTINATION) { AppDetailsContent() }
        composable(CURRENT_APP_DESTINATION) { }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(modifier: Modifier = Modifier) {
    VkEdukationApplicationTheme {

        AppDetailsContent()

    }
}