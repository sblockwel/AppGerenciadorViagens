package com.example.appgerenciadorviagens.dao

import androidx.room.*
import com.example.appgerenciadorviagens.model.Category

@Dao
interface CategoryDao {
    @Insert()
    suspend fun insert(category: Category)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(category: Category)

    @Delete
    suspend fun delete(category: Category)

    @Query("select * from Category c order by c.name")
    suspend fun findAll(): List<Category>

    @Query("select * from Category c where c.id = :id")
    suspend fun findById(id: Int): Category?
}
