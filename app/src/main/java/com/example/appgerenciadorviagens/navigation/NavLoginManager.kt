package com.example.appgerenciadorviagens.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Login
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appgerenciadorviagens.R

sealed class NavLoginManager(val route: String,
                            @StringRes val resourceId: Int
) {
    object Login: NavLoginManager("login", R.string.login)
    object Register : NavLoginManager("register", R.string.register)
    object About : NavLoginManager("about", R.string.about)
}