package com.vickikbt.data.models.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "Games Table")
data class GameEntity(
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "cover")
    @Embedded(prefix = "_cover")
    val cover: CoverEntity?,

    @ColumnInfo(name = "first_release_date")
    val releaseDate: Int?,

    @ColumnInfo(name = "game_modes")
    val gameModes: List<GameModeEntity>?,

    @ColumnInfo(name = "genres")
    val genres: List<GenreEntity>?,

    @ColumnInfo(name = "involved_companies")
    val companies: List<CompaniesEntity>?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "platforms")
    val platforms: List<PlatformEntity>?,

    @ColumnInfo(name = "player_perspectives")
    val perspectives: List<PerspectiveEntity>?,

    @ColumnInfo(name = "screenshots")
    val screenShots: List<ScreenshotEntity>?,

    @ColumnInfo(name = "similar_games")
    val similarGames: List<SimilarGameEntity>?,

    @ColumnInfo(name = "summary")
    val summary: String?,

    @ColumnInfo(name = "storyline")
    val storyLine: String?,

    @ColumnInfo(name = "total_rating")
    val totalRating: Double?,

    @ColumnInfo(name = "videos")
    val videos: List<VideoEntity>?
)