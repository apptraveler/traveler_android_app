package br.com.traveler.models

data class WeatherInformation(
    val id: Int,
    val name: String,
    val minTemperature: Int,
    val maxTemperature: Int
)