package com.example.appgerenciadorviagens.dao

import androidx.lifecycle.LiveData
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

    /*
    @Query("select * from Travel t order by t.destiny")
    suspend fun findAll(): List<Travel>
    */

    @Query("select * from Travel t where t.id = :id")
    suspend fun findById(id: Int): Travel?

    @Query("Select * from Travel t where t.userId = :userId")
    fun getTravelsByUser(userId: Int): LiveData<List<Travel>>

    @Query("select destiny from Travel where Travel.id = :id")
    fun getDestinyByTravel(id: Int): String

    @Query("SELECT CASE WHEN (SELECT COUNT(*) from Spent where travelId = :id) > 0 THEN " +
            "(SELECT SUM(budget) FROM Spent as s inner join Travel t on s.travelId = t.id where " +
            "t.id = :id) ELSE 0.00 END;")
    fun sumSpentsByTravel(id: Int): LiveData<Double>
}