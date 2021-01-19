package com.vickikbt.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.data.models.entity.AuthEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAccessToken(authEntity: AuthEntity)

    @Query("SELECT * FROM Auth_Table")
    fun getAccessToken(): Flow<AuthEntity>

}