package com.example.appgerenciadorviagens.model

import androidx.room.*
import java.time.LocalDate

@Entity(foreignKeys = [
    ForeignKey(entity = Travel::class,
        parentColumns = ["id"],
        childColumns = ["travelId"],
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(entity = Category::class,
        parentColumns = ["id"],
        childColumns = ["categoryId"],
        onDelete = ForeignKey.CASCADE
    )
])
data class Spent (
    val date: LocalDate?,
    val value: Double,
    val description: String,
    val local: String,
    val travelId: Int,
    val categoryId: Int,
    //val category: Category?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}