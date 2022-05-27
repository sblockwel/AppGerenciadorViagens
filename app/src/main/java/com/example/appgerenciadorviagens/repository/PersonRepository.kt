package com.example.appgerenciadorviagens.repository

import android.app.Application
import com.example.appgerenciadorviagens.dao.AppDatabaseConnection
import com.example.appgerenciadorviagens.dao.PersonDao
import com.example.appgerenciadorviagens.model.Person

class PersonRepository(app: Application) {

    private val personDao: PersonDao = TODO()

    init {
        AppDatabaseConnection.getDB(app)
    }

    suspend fun insert(person: Person) {
        if (person.id == 0) {
            personDao.insert(person)
        }
        else{
            personDao.update(person)
        }
    }

    suspend fun findAll() : List<Person> = personDao.findAll()

    suspend fun findById(id: Int) = personDao.findById(id)

    suspend fun delete(person: Person) = personDao.delete(person)
}
