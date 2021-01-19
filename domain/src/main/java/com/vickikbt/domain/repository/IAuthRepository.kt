package com.vickikbt.domain.repository

import com.vickikbt.domain.models.Auth
import kotlinx.coroutines.flow.Flow

interface IAuthRepository {

    suspend fun fetchAccessToken()

    fun getAccessToken():Flow<Auth>

}