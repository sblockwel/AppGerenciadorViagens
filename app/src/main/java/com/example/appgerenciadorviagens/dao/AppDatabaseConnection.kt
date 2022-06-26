package com.example.appgerenciadorviagens.dao

import android.content.Context
import androidx.room.*
import com.example.appgerenciadorviagens.model.Category
import com.example.appgerenciadorviagens.utils.LocalDateConverter
import com.example.appgerenciadorviagens.model.Person
import com.example.appgerenciadorviagens.model.Spent
import com.example.appgerenciadorviagens.model.Travel

@Database(entities = arrayOf(Person::class, Travel::class, Spent::class, Category::class), version = 1 )
@TypeConverters(LocalDateConverter::class)
abstract class AppDatabaseConnection: RoomDatabase() {

    abstract fun personDao(): PersonDao
    abstract fun travelDao(): TravelDao
    abstract fun spentDao(): SpentDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        var connection: AppDatabaseConnection? = null

        fun getDB(context: Context): AppDatabaseConnection {
            val temp = connection
            if (temp != null) {
                return temp
            }
            else {
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