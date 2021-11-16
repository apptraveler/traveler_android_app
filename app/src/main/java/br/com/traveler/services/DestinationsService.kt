package br.com.traveler.services

import br.com.traveler.models.Destination
import retrofit2.Call
import retrofit2.http.GET

interface DestinationsService {
    @GET("91361887-5843-4de1-970e-a753be85c8b6")
    fun getDestinations(): Call<List<Destination>>
}