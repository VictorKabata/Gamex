package com.vickikbt.domain.repository

import com.vickikbt.domain.models.Game
import kotlinx.coroutines.flow.Flow

interface IGamesRepository {

    suspend fun fetchGames(query: String): Flow<List<Game>>

    suspend fun fetchGameDetails(id:Int):Flow<List<Game>>

    //suspend fun saveUnreleasedPopularGames(games: List<Game>)

    //suspend fun saveReleasedPopularGames(games: List<Game>)

}