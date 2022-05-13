package com.example.appgerenciadorviagens.views

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.appgerenciadorviagens.navigation.NavManager

@Composable
fun homeView(navController: NavHostController) {
    val screenList = listOf(
        NavManager.Home,
        NavManager.Travels,
        NavManager.About,
    )
    Scaffold(
        bottomBar = {
            BottomNavigation() {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                screenList.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.resourceId.toString()) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                            }
                        }
                    )
                }
            }
        }
    ) { }
}