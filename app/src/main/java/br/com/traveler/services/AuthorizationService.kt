package br.com.traveler.services

import br.com.traveler.models.User
import br.com.traveler.models.UserCreated
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthorizationService {
    @POST("account/auth")
    fun signIn(@Body user: User): Call<UserCreated>

    @POST("account")
    fun signUp(@Body user: User): Call<UserCreated>

    @PUT("account")
    fun update(@Body user: User): Call<UserCreated>
}