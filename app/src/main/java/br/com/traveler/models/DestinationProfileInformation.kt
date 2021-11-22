package br.com.traveler.models

data class DestinationProfileInformation(
    val id: Int,
    val name: String,
    val country: String,
    val description: String,
    val image: String,
    val weather: WeatherInformation,
    val tourismInformation: String,
    val placesOfInterest: List<PlaceOfInterest>,
    val averageCost: DestinationAverageCostInformation
)