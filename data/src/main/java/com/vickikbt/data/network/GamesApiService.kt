package com.vickikbt.data.network

import com.vickikbt.data.models.dto.GameDto
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface GamesApiService {

    @POST("games/")
    suspend fun fetchPopularGames(
        @Header("Authorization") accessToken: String,
        @Header("Client-ID") clientId: String,
        @Query("fields") fields: String
    ): Response<List<GameDto>>

    @POST("games/")
    suspend fun fetchGameDetailsGames(
        @Header("Authorization") accessToken: String,
        @Header("Client-ID") clientId: String,
        @Query("fields") fields: String
    ): Response<List<GameDto>>
}