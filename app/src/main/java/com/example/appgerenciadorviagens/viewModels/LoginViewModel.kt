package com.example.appgerenciadorviagens.viewModels

import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*

class LoginViewModel  : ViewModel() {

    var username by mutableStateOf("")

    var password by mutableStateOf("")


    fun logar() {
        /*if (username.equals("admin") && password.equals("admin")) {
            onSuccess()
            Toast.makeText(context, "Logado!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Login inválido!", Toast.LENGTH_SHORT).show()

        }*/
    }
}