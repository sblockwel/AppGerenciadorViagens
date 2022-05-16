package com.example.appgerenciadorviagens.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class person (
    val nome: String,
    val email: String,
    val username: String,
    val passwor: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}