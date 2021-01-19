package com.vickikbt.domain.usecases

import com.vickikbt.domain.repository.IAuthRepository

class GetAccessTokenUseCase constructor(private val authRepository: IAuthRepository) {

    operator fun invoke() = authRepository.getAccessToken()
}