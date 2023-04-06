package com.example.uklproject

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Register(
    @PrimaryKey(autoGenerate = true)
    val registId: Int? = null,
    val nama : String,
    val email : String,
    val pass : String,
    val tgllahir: String
)
