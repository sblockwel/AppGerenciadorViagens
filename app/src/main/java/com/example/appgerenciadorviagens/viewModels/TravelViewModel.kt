package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgerenciadorviagens.model.Travel
import com.example.appgerenciadorviagens.repository.TravelRepository
import com.example.appgerenciadorviagens.viewModels.enumerator.TravelTypeEnum
import kotlinx.coroutines.launch
import java.time.LocalDate

class TravelViewModel(private val travelRepository: TravelRepository) : ViewModel() {

    var id by mutableStateOf(0)

    var destiny by mutableStateOf("")

    var type by mutableStateOf(TravelTypeEnum.NONE)

    var arrivalDate by mutableStateOf(LocalDate.now())

    var departureDate by mutableStateOf(LocalDate.now())

    var budget by mutableStateOf(0.00)

    var user by mutableStateOf(0)

    fun register() {
        val travel = Travel(destiny, type, arrivalDate, departureDate, budget, user)
        viewModelScope.launch {
            travelRepository.insert(travel)
        }
    }

    fun getTravelsByUser(userId: Int): LiveData<List<Travel>> {
        return travelRepository.getTravelsByUser(userId)
    }

    fun findById(id: Int) {
        viewModelScope.launch {
            val t = travelRepository.findById(id)
            if (t != null) {
                destiny = t.destiny
            }
            if (t != null) {
                departureDate = t.departureDate
            }
            if (t != null) {
                arrivalDate = t.arrivalDate
            }
            if (t != null) {
                budget = t.budget
            }
        }
    }

    fun sumSpentsByTravel(idViagem: Int): LiveData<Double> {
        return travelRepository.sumSpentsByTravel(idViagem)
    }
}