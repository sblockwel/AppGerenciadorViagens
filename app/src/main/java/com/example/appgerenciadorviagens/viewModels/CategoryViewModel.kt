package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgerenciadorviagens.model.Category
import com.example.appgerenciadorviagens.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    var id by mutableStateOf(-1)

    var name by mutableStateOf("")

    fun register() {

        val category = Category(name)
        viewModelScope.launch {
            categoryRepository.insert(category)
        }
    }
}