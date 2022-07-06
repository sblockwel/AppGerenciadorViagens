package com.example.appgerenciadorviagens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.appgerenciadorviagens.navigation.NavHomeManager
import com.example.appgerenciadorviagens.navigation.NavManager
import com.example.appgerenciadorviagens.ui.theme.AppGerenciadorViagensTheme
import com.example.appgerenciadorviagens.views.forgotPasswordView
import com.example.appgerenciadorviagens.views.loginView
import com.example.appgerenciadorviagens.views.principalNavigation
import com.example.appgerenciadorviagens.views.registerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppGerenciadorViagensTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavManager.Login.route) {
        composable(NavManager.Login.route) { loginView(navController = navController) }
        composable(NavManager.Register.route) { registerView(navController = navController) }
        composable(NavManager.ForgotPassword.route) { forgotPasswordView(navController = navController) }
        composable("home/{username}/{userId}",
            arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                },
                navArgument("userId") {
                    type = NavType.IntType
                }
            )

        ) {
            val username = it.arguments?.getString("username")
            val userId = it.arguments?.getInt("userId")
            if (username != null && userId != null) {
                principalNavigation(username, userId)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppGerenciadorViagensTheme {
        App()
    }
}
