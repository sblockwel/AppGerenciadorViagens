package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TravelViewModel : ViewModel() {

    var id by mutableStateOf("")

    var destino by mutableStateOf("")

    var tipo by mutableStateOf("")

    var dataChegada by mutableStateOf("")

    var dataPartida by mutableStateOf("")

    var orcamento by mutableStateOf("")

    var usuario by mutableStateOf("")
}