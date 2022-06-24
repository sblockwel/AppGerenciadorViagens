package com.example.appgerenciadorviagens.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.example.appgerenciadorviagens.viewModels.enum.TravelTypeEnum
import com.example.appgerenciadorviagens.componente.LocalDateConverter
import java.time.LocalDate


@Entity(foreignKeys = [
    ForeignKey(entity = Person::class,
        parentColumns = ["id"],
        childColumns = ["pessoaId"],
        onDelete = CASCADE)])
data class Travel(
    val destiny: String,
    val type: TravelTypeEnum,
    val arrivalDate: LocalDate?,
    val departureDate: LocalDate?,
    val budget: Double,
    val user: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}