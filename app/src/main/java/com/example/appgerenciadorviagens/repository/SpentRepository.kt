package com.example.appgerenciadorviagens.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.appgerenciadorviagens.dao.AppDatabaseConnection
import com.example.appgerenciadorviagens.dao.SpentDao
import com.example.appgerenciadorviagens.model.Category
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

    suspend fun deleteByID(id : Int) {
        spentDao.deleteById(id)
    }

    fun allSpentsByTravel(viagemID: Int): LiveData<List<Spent>> {
        return spentDao.allDespesasByViagem(viagemID)
    }

}