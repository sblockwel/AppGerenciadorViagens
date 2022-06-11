package com.example.appgerenciadorviagens.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appgerenciadorviagens.viewModels.enum.TravelTypeEnum
import java.time.LocalDate

@Entity
data class Travel(
    val destiny: String,
    val type: TravelTypeEnum ,
    val arrivalDate: LocalDate,
    val departureDate: LocalDate,
    val budget: Double,
    val user: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}