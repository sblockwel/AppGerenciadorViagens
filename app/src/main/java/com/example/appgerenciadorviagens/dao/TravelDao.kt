package com.example.appgerenciadorviagens.dao

import androidx.room.*
import com.example.appgerenciadorviagens.model.Travel

@Dao
interface TravelDao {
    @Insert()
    suspend fun insert(travel: Travel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(travel: Travel)

    @Delete
    suspend fun delete(travel: Travel)

    @Query("select * from Travel t order by t.destiny")
    suspend fun findAll(): List<Travel>

    @Query("select * from Travel t where t.id = :id")
    suspend fun findById(id: Int): Travel?
}