package com.example.appgerenciadorviagens.views

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.appgerenciadorviagens.HomeNavigation
import com.example.appgerenciadorviagens.navigation.NavHomeManager
import com.example.appgerenciadorviagens.navigation.NavManager

@Composable
fun homeView(navController: NavHostController) {
    Text(text = "Home")

    HomeNavigation(navController)
}