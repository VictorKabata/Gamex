package com.vickikbt.data.sources

import androidx.lifecycle.MutableLiveData
import com.vickikbt.data.cache.AppDatabase
import com.vickikbt.data.mappers.toDomain
import com.vickikbt.data.mappers.toEntity
import com.vickikbt.data.models.entity.AuthEntity
import com.vickikbt.data.network.AuthApiService
import com.vickikbt.data.util.Constants.CLIENT_ID
import com.vickikbt.data.util.Constants.CLIENT_SECRET
import com.vickikbt.data.util.Coroutines
import com.vickikbt.data.util.SafeApiRequest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    private val authApiService: AuthApiService,
    private val appDatabase: AppDatabase
) : SafeApiRequest() {

    private val authMutableLiveData = MutableLiveData<AuthEntity>()

    init {
        authMutableLiveData.observeForever { authEntity ->
            saveAccessToken(authEntity)
        }
    }

    suspend fun fetchAccessToken() {
        val accessTokenDto = safeApiRequest {
            authApiService.fetchAccessToken(
                CLIENT_ID,
                CLIENT_SECRET,
                "client_credentials"
            )
        }

        authMutableLiveData.value = accessTokenDto.toEntity()

    }

    fun getAccessToken() = appDatabase.authDao().getAccessToken().map { it?.toDomain() }


    private fun saveAccessToken(authEntity: AuthEntity) {
        Coroutines.io { appDatabase.authDao().saveAccessToken(authEntity) }
    }

}