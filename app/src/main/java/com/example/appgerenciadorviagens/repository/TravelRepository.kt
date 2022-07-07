package com.example.appgerenciadorviagens.repository

import android.app.Application
import androidx.lifecycle.LiveData
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

    fun getTravelsByUser(userId: Int): LiveData<List<Travel>> = travelDao.getTravelsByUser(userId)

    suspend fun findById(id: Int) = travelDao.findById(id)

    suspend fun delete(travel: Travel) = travelDao.delete(travel)

    suspend fun deleteById(id: Int) = travelDao.deleteById(id)

    fun sumSpentsByTravel(idTravel: Int): LiveData<Double> {
        return travelDao.sumSpentsByTravel(idTravel)
    }

}