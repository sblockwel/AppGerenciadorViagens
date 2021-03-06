package com.example.appgerenciadorviagens.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Map
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appgerenciadorviagens.R

sealed class NavHomeManager(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object Home : NavHomeManager("home", R.string.Home, Icons.Filled.Home)
    object Travels : NavHomeManager("travels", R.string.Travels, Icons.Filled.Map)
    object About : NavHomeManager("about", R.string.About, Icons.Filled.Info)

    object RegisterTravel : NavHomeManager("registerTravel", R.string.RegTravel, Icons.Filled.Face)
    object Spent: NavHomeManager("spent", R.string.Spent, Icons.Filled.Face)
    object RegisterSpent: NavHomeManager("registerSpent", R.string.RegSpent, Icons.Filled.Face)
}