package com.example.appgerenciadorviagens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appgerenciadorviagens.ui.theme.AppGerenciadorViagensTheme
import com.example.appgerenciadorviagens.views.AboutView
import com.example.appgerenciadorviagens.views.LoginView
import com.example.appgerenciadorviagens.views.RegisterView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppGerenciadorViagensTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    LoginView().Login();
    /*
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("Login"){
            LoginView()
        }
        composable("Register"){
            RegisterView()
        }
        composable("About"){
            AboutView()
        }
    }*/
}

@Composable
fun Welcome(name: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bem-Vindo(a), ${name}",
            style = MaterialTheme.typography.h4
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppGerenciadorViagensTheme {
        App()
    }
}