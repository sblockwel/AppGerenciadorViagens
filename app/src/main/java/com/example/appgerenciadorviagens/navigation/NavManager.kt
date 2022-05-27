package com.example.appgerenciadorviagens.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appgerenciadorviagens.R

sealed class NavManager(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {

    object Login : NavManager("login", R.string.login, Icons.Filled.Lock)
    object Register : NavManager("register", R.string.register, Icons.Filled.Face)
    object ForgotPassword :
        NavManager("forgotPassword", R.string.forgotPassword, Icons.Filled.Settings)


    //object Home : NavManager("home", R.string.Home, Icons.Filled.Home)
    /*object Travels : NavManager("travels", R.string.Travels, Icons.Filled.Map)
    object About : NavManager("about", R.string.About, Icons.Filled.Info)*/
}