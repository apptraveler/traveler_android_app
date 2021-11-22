package br.com.traveler.models

data class Destination(
    val id: Int,
    val photo: String,
    val destination: String,
    val country: String,
    val tags: List<String>,
    val expenseLevel: Int,
    val tourismLevel: Int,
    val weather: Weather
)
