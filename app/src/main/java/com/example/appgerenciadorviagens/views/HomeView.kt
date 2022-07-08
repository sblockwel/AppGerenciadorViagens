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
import androidx.navigation.NavType
import androidx.navigation.compose.*
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
            composable(NavHomeManager.About.route) {
                // aboutView(navController = navController)
                travelFormCompose(navController, 0, 1)

            }
            composable("registerTravel/{travelId}/{UserId}",
                arguments = listOf(
                    navArgument("travelId") {
                        type = NavType.IntType
                    },
                    navArgument("UserId") {
                        type = NavType.IntType
                    }
                )
            ) {
                val id = it.arguments?.getInt("travelId")
                val idUser = it.arguments?.getInt("UserId")
                if (idUser != null) {
                    travelFormCompose(navController, id, idUser)
                }
            }
           // formTravelGrap(navController, idUserLogged)
            //formDespesaGrap(navController, idUserLogged)
        }
    }
}
