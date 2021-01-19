package com.vickikbt.data.sources

import com.vickikbt.data.cache.AppDatabase
import com.vickikbt.data.mappers.toDomain
import com.vickikbt.data.network.GamesApiService
import com.vickikbt.data.util.Constants.CLIENT_ID
import com.vickikbt.data.util.Constants.GAME_DETAIL
import com.vickikbt.data.util.SafeApiRequest
import com.vickikbt.domain.models.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GamesDataSource @Inject constructor(
    private val gamesApiService: GamesApiService,
    private val appDatabase: AppDatabase
) : SafeApiRequest() {

    suspend fun fetchUnreleasedPopularGames(query: String): Flow<List<Game>> {
        var accessToken: String? = null
        accessToken = "Bearer f3vapq7na1c7y3w5cyek0lvrsu1nj4" //TODO: Make this dynamic
        /*appDatabase.authDao().getAccessToken().map {authEntity->
            accessToken=authEntity.accessToken
        }*/

        val gamesResponse = safeApiRequest {
            gamesApiService.fetchPopularGames(
                accessToken,
                CLIENT_ID,
                query
            )
        }

        return flow { emit(gamesResponse.map { it.toDomain() }) }
    }

    suspend fun fetchGameDetails(id: Int): Flow<List<Game>> {
        val accessToken = "Bearer f3vapq7na1c7y3w5cyek0lvrsu1nj4" //TODO: Make this dynamic

        val gameResponse = safeApiRequest {
            gamesApiService.fetchGameDetailsGames(
                accessToken,
                CLIENT_ID,
                "$GAME_DETAIL$id;"
            )
        }

        return flow { emit(gameResponse.map { it.toDomain() }) }
    }

}