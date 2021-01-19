package com.vickikbt.data.mappers

import com.vickikbt.data.models.entity.*
import com.vickikbt.domain.models.*

internal fun AuthEntity.toDomain() = Auth(this.accessToken, this.expiresIn)

internal fun CompaniesEntity.toDomain() = Companies(this.id, this.company?.toDomain())

internal fun CompanyEntity.toDomain() = Company(this.id, this.name)

internal fun CoverEntity.toDomain() = Cover(this.id, this.imageId)

internal fun GameEntity.toDomain(): Game {
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

internal fun ScreenshotEntity.toDomain() = Screenshot(this.id, this.imageId)

internal fun GameModeEntity.toDomain() = GameMode(this.id, this.name)

internal fun GenreEntity.toDomain() = Genre(this.id, this.name)

internal fun VideoEntity.toDomain() = Video(this.id, this.videoId)

internal fun SimilarGameEntity.toDomain() = SimilarGame(this.id, this.cover?.toDomain(), this.name)

internal fun PerspectiveEntity.toDomain() = Perspective(this.id, this.name)

internal fun PlatformEntity.toDomain() = Platform(this.id, this.name)