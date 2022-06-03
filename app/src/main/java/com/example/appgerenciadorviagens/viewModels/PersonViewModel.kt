package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgerenciadorviagens.model.Person
import com.example.appgerenciadorviagens.repository.PersonRepository
import kotlinx.coroutines.launch

class PersonViewModel(private val personRepository: PersonRepository) : ViewModel() {

    var id by mutableStateOf("")

    var name by mutableStateOf("")

    var username by mutableStateOf("")

    var email by mutableStateOf("")

    var password by mutableStateOf("")

    var confirmPassword by mutableStateOf("")


    fun register() {

        val person = Person(name, email, username, password)
        viewModelScope.launch {
            personRepository.insert(person)
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