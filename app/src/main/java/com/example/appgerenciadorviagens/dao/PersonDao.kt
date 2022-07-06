package com.example.appgerenciadorviagens.dao

import androidx.room.*
import com.example.appgerenciadorviagens.model.Person

@Dao
interface PersonDao {
    @Insert()
    suspend fun insert(person: Person)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query("select * from Person p order by p.name")
    suspend fun findAll(): List<Person>

    @Query("select * from Person p where p.id = :id")
    suspend fun findById(id: Int): Person?

    @Query("select * from Person p where p.username = :username and p.password = :password")
    suspend fun login(username: String, password: String): Person?
}