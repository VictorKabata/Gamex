package com.vickikbt.domain.usecases

import com.vickikbt.domain.models.Game
import com.vickikbt.domain.repository.IGamesRepository

class CacheUnreleasedPopularGamesUseCase constructor(private val gamesRepository: IGamesRepository) {

    //suspend operator fun invoke(games:List<Game>)=gamesRepository.saveUnreleasedPopularGames(games)

}