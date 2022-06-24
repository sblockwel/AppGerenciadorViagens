package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgerenciadorviagens.model.Spent
import com.example.appgerenciadorviagens.repository.SpentRepository
import kotlinx.coroutines.launch
import java.time.LocalDate

class SpentViewModel(private val spenteRepository: SpentRepository) : ViewModel() {

    var id by mutableStateOf(0)

    var description by mutableStateOf("")

    var local by mutableStateOf("")

    var date by mutableStateOf(LocalDate.now())

    var value by mutableStateOf(0.00)

    var travel by mutableStateOf(-1)

    var category by mutableStateOf(-1)

    fun register() {

        val spent = Spent(date, value, description, local, travel, category)
        viewModelScope.launch {
            spenteRepository.insert(spent)
        }
    }
}