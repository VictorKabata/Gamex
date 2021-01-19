package com.vickikbt.domain.usecases

import com.vickikbt.domain.models.Game
import com.vickikbt.domain.repository.IGamesRepository

class CacheReleasedPopularGamesUseCase constructor(private val gamesRepository: IGamesRepository) {

    //suspend operator fun invoke(games:List<Game>)=gamesRepository.saveReleasedPopularGames(games)

}