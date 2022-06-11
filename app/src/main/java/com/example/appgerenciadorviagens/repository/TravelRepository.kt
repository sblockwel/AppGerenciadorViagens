package com.example.appgerenciadorviagens.repository

import android.app.Application
import com.example.appgerenciadorviagens.dao.AppDatabaseConnection
import com.example.appgerenciadorviagens.dao.TravelDao
import com.example.appgerenciadorviagens.model.Travel

class TravelRepository(app: Application) {

    private val travelDao: TravelDao

    init {
        travelDao = AppDatabaseConnection.getDB(app).travelDao()
    }

    suspend fun insert(travel: Travel) {
        if (travel.id == 0) {
            travelDao.insert(travel)
        } else {
            travelDao.update(travel)
        }
    }

    suspend fun findAll(): List<Travel> = travelDao.findAll()

    suspend fun findById(id: Int) = travelDao.findById(id)

    suspend fun delete(travel: Travel) = travelDao.delete(travel)

}