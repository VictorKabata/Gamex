package com.vickikbt.data.mappers

import com.vickikbt.data.models.dto.*
import com.vickikbt.domain.models.*

internal fun CompaniesDto.toDomain() = Companies(this.id, this.company?.toDomain())

internal fun CompanyDto.toDomain() = Company(this.id, this.name)

internal fun CoverDto.toDomain() = Cover(this.id, this.imageId)

internal fun GameDto.toDomain(): Game {
    return Game(
        this.id,
        this.cover?.toDomain(),
        this.releaseDate,
        this.gameModes?.map { it.toDomain() },
        this.genres?.map { it.toDomain() },
        this.companies?.map { it.toDomain() },
        this.name,
        this.platforms?.map { it.toDomain() },
        this.perspectives?.map { it.toDomain() },
        this.screenShots?.map { it.toDomain() },
        this.similarGames?.map { it.toDomain() },
        this.summary,
        this.storyLine,
        this.totalRating,
        this.videos?.map { it.toDomain() }
    )
}

internal fun ScreenshotDto.toDomain() = Screenshot(this.id, this.imageId)

internal fun GameModeDto.toDomain() = GameMode(this.id, this.name)

internal fun GenreDto.toDomain() = Genre(this.id, this.name)

internal fun SimilarGameDto.toDomain()=SimilarGame(this.id, this.cover?.toDomain(), this.name)

internal fun VideoDto.toDomain() = Video(this.id, this.videoId)

internal fun PerspectiveDto.toDomain() = Perspective(this.id, this.name)

internal fun PlatformDto.toDomain() = Platform(this.id, this.name)