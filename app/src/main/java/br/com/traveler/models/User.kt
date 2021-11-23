package br.com.traveler.models

data class User(
    val email: String,
    val password: String,
    val name: String? = null
)