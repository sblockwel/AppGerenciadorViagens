package com.example.appgerenciadorviagens.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*

class PessoaViewModel : ViewModel() {

    var nome by mutableStateOf("")

    var senha by mutableStateOf("")

    var dataNascimento by mutableStateOf("")

    var email by mutableStateOf("")


    fun registrar() {

    }

}