package br.com.traveler.services

import br.com.traveler.models.User
import retrofit2.Call
import retrofit2.http.GET

interface ServiceTraveler {
    @GET("1637ac6d-e983-41be-8f3b-f7dbd82c810f")
    fun signIn() : Call<User>
}