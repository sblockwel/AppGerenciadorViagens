package com.example.appgerenciadorviagens.dao

import android.content.Context
import androidx.room.*
import com.example.appgerenciadorviagens.componente.LocalDateConverter
import com.example.appgerenciadorviagens.model.Person
import com.example.appgerenciadorviagens.model.Travel

@Database(entities = arrayOf(Person::class, Travel::class), version = 1 )
@TypeConverters(LocalDateConverter::class)
abstract class AppDatabaseConnection: RoomDatabase() {

    abstract fun personDao(): PersonDao
    abstract fun travelDao(): TravelDao

    // Desing Pattern - Singleton
    companion object {
        var connection: AppDatabaseConnection? = null

        fun getDB(context: Context): AppDatabaseConnection {
            val temp = connection
            if (temp != null) {
                return temp
            }
            else {
                // conectar o banco
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabaseConnection::class.java,
                    "meu-database"
                ).build()
                connection = instance
                return instance
            }
        }

    }
}