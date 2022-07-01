package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    var user by mutableStateOf(-1)

    fun register() {

        val travel = Travel(destiny, type, arrivalDate, departureDate, budget, user)
        viewModelScope.launch {
            travelRepository.insert(travel)
        }
        /*val person = Person(name, username, email, password)

        viewModelScope.launch {
            personRepository.insert(person)
        }*/

        /* try {
             validate(this) {
                 validate(PessoaViewModel::username).isNotEmpty().hasSize(4, 12)
                 validate(PessoaViewModel::email).isEmail()
                 validate(PessoaViewModel::password).isNotEmpty().hasSize(6, 10)
                 validate(PessoaViewModel::confirmPassword).isNotEmpty().hasSize(6, 10)
                     .isEqualTo(password)
             }
         } catch (ex: ConstraintViolationException) {
             for (violation in ex.constraintViolations){
                 Toast.makeText(context, "${violation.property}: ${violation.constraint.name}", Toast.LENGTH_SHORT)
             }
         }*/
    }
}