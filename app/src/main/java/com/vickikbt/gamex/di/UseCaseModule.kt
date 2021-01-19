package com.vickikbt.gamex.di

import com.vickikbt.data.cache.AppDatabase
import com.vickikbt.data.network.AuthApiService
import com.vickikbt.data.network.GamesApiService
import com.vickikbt.data.repository.AuthRepository
import com.vickikbt.data.repository.GamesRepository
import com.vickikbt.data.sources.AuthDataSource
import com.vickikbt.data.sources.GamesDataSource
import com.vickikbt.domain.usecases.FetchAccessTokenUseCase
import com.vickikbt.domain.usecases.FetchGameDetailsUseCase
import com.vickikbt.domain.usecases.FetchGamesUseCase
import com.vickikbt.domain.usecases.GetAccessTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)

@Module
object UseCaseModule {

    @Provides
    fun providesAuthDataSource(authApiService: AuthApiService, appDatabase: AppDatabase) =
        AuthDataSource(authApiService, appDatabase)

    @Provides
    fun providesAuthRepository(authDataSource: AuthDataSource) = AuthRepository(authDataSource)

    @Provides
    fun providesFetchAccessTokenUseCase(authRepository: AuthRepository) =
        FetchAccessTokenUseCase(authRepository)

    @Provides
    fun providesGetAccessTokenUseCase(authRepository: AuthRepository) =
        GetAccessTokenUseCase(authRepository)

    @Provides
    fun providesGamesDataSource(gamesApiService: GamesApiService, appDatabase: AppDatabase) =
        GamesDataSource(gamesApiService, appDatabase)

    @Provides
    fun providesGamesRepository(gamesDataSource: GamesDataSource) = GamesRepository(gamesDataSource)

    @Provides
    fun providesFetchGamesUseCase(gamesRepository: GamesRepository) =
        FetchGamesUseCase(gamesRepository)

    @Provides
    fun providesFetchGameDetailsUseCase(gamesRepository: GamesRepository) =
        FetchGameDetailsUseCase(gamesRepository)

}