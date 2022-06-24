package com.example.appgerenciadorviagens.dao

import androidx.room.*
import com.example.appgerenciadorviagens.model.Spent
import com.example.appgerenciadorviagens.model.Travel

@Dao
interface SpentDao {
    @Insert()
    suspend fun insert(spent: Spent)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(spent: Spent)

    @Delete
    suspend fun delete(spent: Spent)

    @Query("select * from Spent s order by s.description")
    suspend fun findAll(): List<Spent>

    @Query("select * from Spent s where s.id = :id")
    suspend fun findById(id: Int): Spent?
}