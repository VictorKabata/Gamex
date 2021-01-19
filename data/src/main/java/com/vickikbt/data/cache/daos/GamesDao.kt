package com.vickikbt.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import com.vickikbt.data.models.entity.GameEntity

@Dao
interface GamesDao {

    @Insert
    suspend fun cacheUnreleasedPopularGames(games: List<GameEntity>)

    @Insert
    suspend fun cacheReleasedPopularGames(games: List<GameEntity>)

    //@Query("SELECT * FROM `Games Table`")
    //suspend fun

}