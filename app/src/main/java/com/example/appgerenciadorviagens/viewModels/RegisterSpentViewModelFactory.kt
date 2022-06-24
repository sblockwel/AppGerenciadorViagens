package com.example.appgerenciadorviagens.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appgerenciadorviagens.repository.SpentRepository
import com.example.appgerenciadorviagens.repository.TravelRepository

class RegisterSpentViewModelFactory(val app: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val repository = SpentRepository(app)
        val model = SpentViewModel(repository)
        return model as T
    }
}