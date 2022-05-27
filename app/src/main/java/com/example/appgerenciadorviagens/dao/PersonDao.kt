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

    @Query("select * from Person order by nome")
    suspend fun findAll(): List<Person>

    @Query("select * from Person c where c.id = :id")
    suspend fun findById(id: Int): Person?
}