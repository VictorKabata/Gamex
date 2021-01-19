package com.vickikbt.domain.usecases

import com.vickikbt.domain.repository.IGamesRepository

class FetchGameDetailsUseCase constructor(private val gamesRepository: IGamesRepository) {

    suspend operator fun invoke(id: Int) = gamesRepository.fetchGameDetails(id)

}