package com.example.appgerenciadorviagens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appgerenciadorviagens.ui.theme.AppGerenciadorViagensTheme
import com.example.appgerenciadorviagens.views.LoginView

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
    LoginView().Login();
    /*val navController = rememberNavController()
    val items = listOf(
        ScreenManagger.Home,
        ScreenManagger.Profile,
        ScreenManagger.About
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = ScreenManagger.Home.route, Modifier.padding(innerPadding)) {
            composable(ScreenManagger.Home.route) { HomeCompose() }
            composable(ScreenManagger.Profile.route) { ProfileCompose(navController = navController) }
            composable(ScreenManagger.About.route){ AboutCompose() }
        }
    }*/

    NavHost(navController = navController, startDestination = "home") {
        composable("Home"){
            HomeCompose()
        }
        composable("Profile"){
            ProfileCompose(navController)
        }
        composable("About"){
            AboutCompose()
        }
    }
}

@Composable
fun Welcome(name: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bem-Vindo(a), ${name}",
            style = MaterialTheme.typography.h4
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppGerenciadorViagensTheme {
        App()
    }
}