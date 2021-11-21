package com.github.tutorialseu.models

data class UserList (
    val users: ArrayList<User>
)

// Clase modelo con estructura de datos de usuario
data class User (
    val id: Int,
    val name: String,
    val email: String,
    val gender: String,
    val weight: Double,
    val height: Int,
    val phone: Phone
)

data class Phone (
    val mobile: String,
    val office: String
)