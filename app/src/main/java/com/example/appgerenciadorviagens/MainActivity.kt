package com.example.appgerenciadorviagens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.appgerenciadorviagens.navigation.NavHomeManager
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
    /*val navController = rememberNavController()
    Column() {
        loginView(navController = navController)

        NavHost(navController = navController, startDestination = "login") {
            loginGraph(navController)
        }
    }*/

    val navController = rememberNavController()
    val items = listOf(
        NavHomeManager.Home,
        NavHomeManager.Travels,
        NavHomeManager.About
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {

                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = NavHomeManager.Home.route, Modifier.padding(innerPadding)) {
            composable(NavHomeManager.Home.route) { homeView() }
            composable(NavHomeManager.Travels.route) { travelView() }
            composable(NavHomeManager.About.route) { aboutView() }
            //loginGraph(navController)
        }
    }

}

fun NavGraphBuilder.loginGraph(navController: NavHostController) {
    navigation(startDestination = "principal", route = "login") {
        composable("principal") { loginView(navController) }
        composable("home") { homeView() }
        composable("forgotPassword") { forgotPasswordView() }
        composable("register") { registerView(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppGerenciadorViagensTheme {
        App()
    }
}