package com.vickikbt.data.models.dto

import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("cover")
    val cover: CoverDto?,

    @SerializedName("first_release_date")
    val releaseDate: Int?,

    @SerializedName("game_modes")
    val gameModes: List<GameModeDto>?,

    @SerializedName("genres")
    val genres: List<GenreDto>?,

    @SerializedName("involved_companies")
    val companies: List<CompaniesDto>?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("platforms")
    val platforms: List<PlatformDto>?,

    @SerializedName("player_perspectives")
    val perspectives: List<PerspectiveDto>?,

    @SerializedName("screenshots")
    val screenShots: List<ScreenshotDto>?,

    @SerializedName("similar_games")
    val similarGames: List<SimilarGameDto>?,

    @SerializedName("summary")
    val summary: String?,

    @SerializedName("storyline")
    val storyLine: String?,

    @SerializedName("total_rating")
    val totalRating: Double?,

    @SerializedName("videos")
    val videos: List<VideoDto>?
)