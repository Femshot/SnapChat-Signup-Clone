package com.example.snapchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snapchat.ui.theme.SnapChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnapChatTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    navController.currentBackStackEntry
    NavHost(navController, startDestination = "main") {
        composable("main") {
            SignUp( navigate = { route ->
                navController.navigate(route)
            })
        }
        composable("second/{name}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                    defaultValue = "Fish"
                }
            )
        ) {
            val name = it.arguments?.getString("name")
            SignIn(name = name)
        }
    }
}






