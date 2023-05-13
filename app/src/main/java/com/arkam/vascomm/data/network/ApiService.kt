package com.arkam.vascomm.data.network

import com.arkam.vascomm.data.network.response.LoginResponse
import com.arkam.vascomm.model.LoginUser
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("api/login")
    fun userLogin(
        @Body loginBody : LoginUser
    ): Call<LoginResponse>

}