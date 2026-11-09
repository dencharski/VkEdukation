package com.example.vkedukationapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vkedukationapplication.MainActivity.Companion.CURRENT_APP_DESTINATION
import com.example.vkedukationapplication.MainActivity.Companion.DETAILS_DESTINATION
import com.example.vkedukationapplication.ui.current_app_screen.CurrentAppDetailsContent
import com.example.vkedukationapplication.ui.showcase_screen.AppDetailsContent
import com.example.vkedukationapplication.ui.theme.VkEdukationApplicationTheme

class MainActivity : ComponentActivity() {
    companion object {
        public val DETAILS_DESTINATION = "details"
        public val CURRENT_APP_DESTINATION = "current_app"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEdukationApplicationTheme {
                RootNavHost()

            }
        }
    }
}

@Composable
fun RootNavHost() {


    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DETAILS_DESTINATION, // Стартовый экран будет тут
    ) {
        composable(DETAILS_DESTINATION) { AppDetailsContent(navController) }
        composable(
            route = CURRENT_APP_DESTINATION + "/{current_app_id}",
            arguments = listOf(navArgument("current_app_id") { type = NavType.StringType })
        )
        { stackEntry ->
            val currentAppId = stackEntry.arguments?.getString("current_app_id")
            CurrentAppDetailsContent(currentAppId = currentAppId, navController)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    VkEdukationApplicationTheme {

        AppDetailsContent(navController)

    }
}