package com.example.appgerenciadorviagens.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (
    val name: String,
    val email: String,
    val username: String,
    val password: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}