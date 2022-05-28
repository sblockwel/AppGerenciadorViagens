package com.example.appgerenciadorviagens.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun aboutView(navController: NavHostController) {
    Column() {
        Text(text = "About")
    }
}