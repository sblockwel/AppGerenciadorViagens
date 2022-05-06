package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*

class PessoaViewModel : ViewModel() {

    var username by mutableStateOf("")

    var password by mutableStateOf("")

    var confirmPassword by mutableStateOf("")

    var email by mutableStateOf("")


    fun registrar() {

    }

}