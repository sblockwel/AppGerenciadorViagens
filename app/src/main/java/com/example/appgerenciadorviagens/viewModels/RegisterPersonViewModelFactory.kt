package com.example.appgerenciadorviagens.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appgerenciadorviagens.repository.PersonRepository

class RegisterPersonViewModelFactory(val app: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val repository = PersonRepository(app)
        val model = PersonViewModel(repository)
        return model as T
    }

}