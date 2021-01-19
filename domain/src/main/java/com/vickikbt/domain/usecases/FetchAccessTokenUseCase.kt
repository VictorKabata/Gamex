package com.vickikbt.domain.usecases

import com.vickikbt.domain.repository.IAuthRepository

class FetchAccessTokenUseCase constructor(private val authRepository: IAuthRepository) {

    suspend operator fun invoke() = authRepository.fetchAccessToken()
}