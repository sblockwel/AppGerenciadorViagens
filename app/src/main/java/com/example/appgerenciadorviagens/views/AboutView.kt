package com.example.appgerenciadorviagens.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun aboutView(navController: NavController) {
    Column() {
        Text(text = "About")
    }
}