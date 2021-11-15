package br.com.traveler.services

import br.com.traveler.models.Destination
import retrofit2.Call
import retrofit2.http.GET

interface ServiceDestination {
    @GET("8ca51d7a-deab-41f5-ad42-8a3855cb864c")
    fun getDestinations(): Call<Destination>
}