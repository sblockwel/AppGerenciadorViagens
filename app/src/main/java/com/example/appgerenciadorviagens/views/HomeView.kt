package com.example.appgerenciadorviagens.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appgerenciadorviagens.navigation.NavHomeManager
import com.example.appgerenciadorviagens.navigation.NavManager

@Composable
fun homeView() {
    Text(text = "Home")
}


@Composable
fun principalNavigation(nameUserLogged: String, idUserLogged: Int) {
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
        NavHost(
            navController,
            startDestination = NavHomeManager.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(NavHomeManager.Home.route) { homeView() }
            composable(NavHomeManager.Travels.route) { travelCompose(navController = navController, idUserLogged) }
            composable(NavHomeManager.About.route) { aboutView(navController = navController) }
            composable(NavHomeManager.RegisterTravel.route) { travelForm(navController, id, idUserLogged) }
        }
    }
}
/*

Scaffold(
bottomBar = {
    androidx.compose.material.BottomNavigation(
        backgroundColor = MaterialTheme.colors.secondary,
//        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = {
                    Text(
                        text = stringResource(item.resourceId),
                        fontSize = 12.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
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
    NavHost(
        navController = navController,
        startDestination = ScreenManager.Home.route,
        Modifier.padding(innerPadding)
    ) {
        composable(ScreenManager.Home.route) { HomeCompose() }
        composable(ScreenManager.Viagens.route) { ViagensCompose(navController = navController) }
        composable(ScreenManager.Sobre.route) { SobreCompose() }
//            composable(ScreenManager.FormViagem.route) { FormViagem(navController = navController, 0) }
        formViagemGrap(navController)
    }
}*/