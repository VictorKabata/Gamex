package com.vickikbt.domain.usecases

import com.vickikbt.domain.repository.IGamesRepository

class FetchGamesUseCase constructor(private val gamesRepository: IGamesRepository) {

    suspend operator fun invoke(query:String)=gamesRepository.fetchGames(query)

}