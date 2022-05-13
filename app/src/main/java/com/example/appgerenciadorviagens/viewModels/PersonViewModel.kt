package com.example.appgerenciadorviagens.viewModels

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.hasSize
import org.valiktor.functions.isEmail
import org.valiktor.functions.isEqualTo
import org.valiktor.functions.isNotEmpty
import org.valiktor.validate

class PersonViewModel(/*val context: Context*/) : ViewModel() {

    var id by mutableStateOf("")

    var name by mutableStateOf("")

    var username by mutableStateOf("")

    var email by mutableStateOf("")

    var password by mutableStateOf("")

    var confirmPassword by mutableStateOf("")


    fun register() {
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