package com.example.appgerenciadorviagens.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appgerenciadorviagens.repository.CategoryRepository

class RegisterCategoryViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val repository = CategoryRepository(app)
        val model = CategoryViewModel(repository)
        return model as T
    }
}