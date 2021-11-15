package br.com.traveler.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun serviceTraveler() : ServiceTraveler {
        return retrofit.create(ServiceTraveler::class.java)
    }
}