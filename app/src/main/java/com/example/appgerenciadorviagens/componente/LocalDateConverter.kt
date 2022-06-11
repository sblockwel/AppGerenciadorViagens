package com.example.appgerenciadorviagens.componente

import androidx.room.TypeConverter
import java.time.LocalDate

class LocalDateConverter {

    @TypeConverter
    fun fromLong(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(value) }
    }

    @TypeConverter
    fun dateToLong(date: LocalDate?): Long? {
        return date?.toEpochDay()
    }
}