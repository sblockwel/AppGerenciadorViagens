package com.example.appgerenciadorviagens.navigation

import androidx.annotation.StringRes
import com.example.appgerenciadorviagens.R

sealed class NavLoginManager(val route: String,
                            @StringRes val resourceId: Int
) {
    object Login: NavLoginManager("login", R.string.login)
    object Register : NavLoginManager("register", R.string.register)
    object ForgotPassword : NavLoginManager("forgotPassword", R.string.forgotPassword)
}