package com.example.appgerenciadorviagens.repository

import android.app.Application
import com.example.appgerenciadorviagens.dao.AppDatabaseConnection
import com.example.appgerenciadorviagens.dao.SpentDao
import com.example.appgerenciadorviagens.model.Spent

class SpentRepository(app: Application) {

    private val spentDao: SpentDao

    init {
        spentDao = AppDatabaseConnection.getDB(app).spentDao()
    }

    suspend fun insert(spent: Spent) {
        if (spent.id == 0) {
            spentDao.insert(spent)
        } else {
            spentDao.update(spent)
        }
    }

    suspend fun findAll(): List<Spent> = spentDao.findAll()

    suspend fun findById(id: Int) = spentDao.findById(id)

    suspend fun delete(spent: Spent) = spentDao.delete(spent)
}