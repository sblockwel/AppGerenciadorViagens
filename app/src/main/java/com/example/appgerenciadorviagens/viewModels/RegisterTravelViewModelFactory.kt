package com.example.appgerenciadorviagens.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appgerenciadorviagens.repository.TravelRepository


class RegisterTravelViewModelFactory(val app: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val repository = TravelRepository(app)
        val model = TravelViewModel(repository)
        return model as T
    }
}