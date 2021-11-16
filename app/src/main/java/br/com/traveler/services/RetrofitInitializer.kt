package br.com.traveler.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAuthorizationService(): AuthorizationService {
        return retrofit.create(AuthorizationService::class.java)
    }

    fun getDestinationsService(): DestinationsService {
        return retrofit.create(DestinationsService::class.java)
    }
}