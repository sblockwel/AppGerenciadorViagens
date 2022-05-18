package com.example.appgerenciadorviagens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appgerenciadorviagens.navigation.NavHomeManager
import com.example.appgerenciadorviagens.navigation.NavManager
import com.example.appgerenciadorviagens.ui.theme.AppGerenciadorViagensTheme
import com.example.appgerenciadorviagens.views.*

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
    NavHost(
        navController,
        startDestination = NavManager.Login.route
    ) {
        composable(NavManager.Login.route) { loginView(navController) }
        composable(NavManager.Register.route) { registerView(navController) }
        composable(NavManager.ForgotPassword.route) { forgotPasswordView(navController) }
        composable(NavManager.Home.route) { homeView(navController) }
    }
    //HomeNavigation(navController)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppGerenciadorViagensTheme {
        App()
    }
}
