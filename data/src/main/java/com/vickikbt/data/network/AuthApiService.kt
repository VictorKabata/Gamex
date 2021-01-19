package com.vickikbt.data.network

import com.vickikbt.data.models.dto.AuthDto
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiService {

    @POST("token")
    suspend fun fetchAccessToken(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("grant_type") grantType: String
    ): Response<AuthDto>

}