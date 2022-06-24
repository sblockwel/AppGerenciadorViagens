package com.example.appgerenciadorviagens.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.appgerenciadorviagens.model.Category
import com.example.appgerenciadorviagens.model.Spent
import kotlinx.coroutines.launch

class CategoryViewModel {

    var id by mutableStateOf(0)

    var name by mutableStateOf("")

    fun register() {
        val category = Category(name)
        categoryViewModel.launch {
            category.insert(spent)
        }
    }
}