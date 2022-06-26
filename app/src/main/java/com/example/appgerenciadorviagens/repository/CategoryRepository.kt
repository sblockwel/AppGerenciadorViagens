package com.example.appgerenciadorviagens.repository

import android.app.Application
import com.example.appgerenciadorviagens.dao.AppDatabaseConnection
import com.example.appgerenciadorviagens.dao.CategoryDao
import com.example.appgerenciadorviagens.model.Category

class CategoryRepository(app: Application) {

    private val categoryDao: CategoryDao

    init {
        categoryDao = AppDatabaseConnection.getDB(app).categoryDao()
    }

    suspend fun insert(category: Category) {
        if (category.id == 0) {
            categoryDao.insert(category)
        } else {
            categoryDao.update(category)
        }
    }

    suspend fun findAll(): List<Category> = categoryDao.findAll()

    suspend fun findById(id: Int) = categoryDao.findById(id)

    suspend fun delete(category: Category) = categoryDao.delete(category)
}