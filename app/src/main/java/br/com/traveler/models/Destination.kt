package br.com.traveler.models

data class Destination(
    val photo: String,
    val destination: String,
    val country: String,
    val tags: Array<String>,
    val priceLevel: Int,
    val tourismLevel: Int,
    val wheater: Array<Wheater>
)