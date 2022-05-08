package com.example.appgerenciadorviagens.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appgerenciadorviagens.R

sealed class NavHomeManager(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object Home : NavHomeManager("home", R.string.Home, Icons.Filled.Home)
    object Travels : NavHomeManager("travels", R.string.Travels, Icons.Filled.Map)
    object About : NavHomeManager("about", R.string.About, Icons.Filled.Help)
}