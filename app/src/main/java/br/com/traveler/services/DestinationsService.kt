package br.com.traveler.services

import br.com.traveler.models.Destination
import br.com.traveler.models.DestinationProfileInformation
import retrofit2.Call
import retrofit2.http.GET

interface DestinationsService {
    @GET("e04c35d5-374e-4676-93e7-db8c0aa047b3")
    fun getDestinations(): Call<List<Destination>>

    @GET("6d7b6421-3979-4769-b976-d9c1a0ff7046")
    fun getDestinationProfile(): Call<List<DestinationProfileInformation>>
}