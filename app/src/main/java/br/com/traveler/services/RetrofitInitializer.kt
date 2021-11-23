package br.com.traveler.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofitMocky = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitFluo = Retrofit.Builder()
        .baseUrl("https://api.fluo.work/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAuthorizationService(): AuthorizationService {
        return retrofitFluo.create(AuthorizationService::class.java)
    }

    fun getDestinationsService(): DestinationsService {
        return retrofitMocky.create(DestinationsService::class.java)
    }
}