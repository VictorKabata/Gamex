package com.vickikbt.domain.models

data class Game(
    val id: Int?,
    val cover: Cover?,
    val releaseDate: Int?,
    val gameModes: List<GameMode>?,
    val genres: List<Genre>?,
    val companies: List<Companies>?,
    val name: String?,
    val platforms: List<Platform>?,
    val perspectives: List<Perspective>?,
    val screenShots: List<Screenshot>?,
    val similarGames: List<SimilarGame>?,
    val summary: String?,
    val storyLine:String?,
    val totalRating: Double?,
    val videos: List<Video>?
)