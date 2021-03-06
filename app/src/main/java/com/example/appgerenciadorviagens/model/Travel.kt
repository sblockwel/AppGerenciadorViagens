package com.example.appgerenciadorviagens.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.example.appgerenciadorviagens.viewModels.enumerator.TravelTypeEnum
import java.time.LocalDate


@Entity(foreignKeys = [
    ForeignKey(entity = Person::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = CASCADE)])
data class Travel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val destiny: String,
    val type: TravelTypeEnum,
    val arrivalDate: LocalDate?,
    val departureDate: LocalDate?,
    val budget: Double,
    val userId: Int
) {

}