package com.vickikbt.data.repository

import com.vickikbt.data.sources.GamesDataSource
import com.vickikbt.domain.repository.IGamesRepository
import javax.inject.Inject

class GamesRepository @Inject constructor(private val gamesDataSource: GamesDataSource) :
    IGamesRepository {


    override suspend fun fetchGames(query: String) =
        gamesDataSource.fetchUnreleasedPopularGames(query)

    override suspend fun fetchGameDetails(id: Int) = gamesDataSource.fetchGameDetails(id)

    /*override suspend fun saveUnreleasedPopularGames(games: List<Game>) {
        //TODO: Implement
    }

    override suspend fun saveReleasedPopularGames(games: List<Game>) {
        //TODO: Implement
    }*/
}