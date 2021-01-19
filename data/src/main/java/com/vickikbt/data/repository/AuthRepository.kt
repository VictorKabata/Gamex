package com.vickikbt.data.repository

import com.vickikbt.data.sources.AuthDataSource
import com.vickikbt.domain.repository.IAuthRepository
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authDataSource: AuthDataSource) :
    IAuthRepository {

    override suspend fun fetchAccessToken() = authDataSource.fetchAccessToken()

    override fun getAccessToken() = authDataSource.getAccessToken()


}