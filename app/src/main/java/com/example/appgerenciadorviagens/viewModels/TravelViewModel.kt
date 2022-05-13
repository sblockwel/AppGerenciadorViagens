package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appgerenciadorviagens.viewModels.enum.TravelTypeEnum

class TravelViewModel : ViewModel() {

    var id by mutableStateOf(0)

    var destiny by mutableStateOf("")

    var type by mutableStateOf(TravelTypeEnum.LAZER)

    var arrivalDate by mutableStateOf("")

    var departureDate by mutableStateOf("")

    var budget by mutableStateOf(0.00)

    var user by mutableStateOf("")
}