package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgerenciadorviagens.model.Category
import com.example.appgerenciadorviagens.model.Spent
import com.example.appgerenciadorviagens.repository.SpentRepository
import kotlinx.coroutines.launch
import java.time.LocalDate

class SpentViewModel(private val spentRepository: SpentRepository) : ViewModel() {

    var id by mutableStateOf(0)

    var description by mutableStateOf("")

    var local by mutableStateOf("")

    var date by mutableStateOf(LocalDate.now())

    var value by mutableStateOf(0.00)

    var travel by mutableStateOf(0)

    var category by mutableStateOf(0)

    //var nameCategory by mutableStateOf()

    private fun mutableStateOf() {
        TODO("Not yet implemented")
    }

    fun register() {
        val spent = Spent(date, value, description, local, travel, category)
        viewModelScope.launch {
            spentRepository.insert(spent)
        }
    }

    fun allSpentsByTravel(travelId: Int): LiveData<List<Spent>> {
        return spentRepository.allSpentsByTravel(travelId)
    }

    fun deleteById(id: Int) {
        viewModelScope.launch {
            spentRepository.deleteByID(id)
        }
    }

    fun findById(id: Int) {
        viewModelScope.launch {
            val s = spentRepository.findById(id)
            if (s != null) {
                description = s.description
                local = s.local
                date = s.date
                value = s.value
            }
        }
    }
}