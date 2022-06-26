package com.example.appgerenciadorviagens.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.example.appgerenciadorviagens.viewModels.enum.TravelTypeEnum
import java.time.LocalDate


@Entity(foreignKeys = [
    ForeignKey(entity = Person::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = CASCADE)])
data class Travel(
    var destiny: String,
    var type: TravelTypeEnum,
    var arrivalDate: LocalDate?,
    var departureDate: LocalDate?,
    var budget: Double,
    var userId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}