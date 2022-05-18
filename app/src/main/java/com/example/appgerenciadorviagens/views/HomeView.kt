package com.example.appgerenciadorviagens.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.appgerenciadorviagens.navigation.NavHomeManager

@Composable
fun homeView(navController: NavHostController) {
    Text(text = "Home")

    HomeNavigation(navController)
}


@Composable
fun HomeNavigation(navController: NavHostController) {
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
        NavHost(
            navController,
            startDestination = NavHomeManager.Home.route,
            Modifier.padding(innerPadding)
        ) {
            //composable(NavHomeManager.Home.route) { homeView(navController) }
            composable(NavHomeManager.Travels.route) { travelView(navController) }
            composable(NavHomeManager.About.route) { aboutView(navController) }
        }
    }
}