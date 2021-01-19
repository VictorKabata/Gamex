package com.vickikbt.data.mappers

import com.vickikbt.data.models.dto.*
import com.vickikbt.data.models.entity.*

internal fun AuthDto.toEntity() = AuthEntity(this.accessToken!!, this.expiresIn!!)

internal fun CompaniesDto.toEntity() = CompaniesEntity(this.id, this.company?.toEntity())

internal fun CompanyDto.toEntity() = CompanyEntity(this.id, this.name)

internal fun CoverDto.toEntity() = CoverEntity(this.id, this.imageId)

internal fun GameDto.toEntity(): GameEntity {
    return GameEntity(
        this.id,
        this.cover?.toEntity(),
        this.releaseDate,
        this.gameModes?.map { it.toEntity() },
        this.genres?.map { it.toEntity() },
        this.companies?.map { it.toEntity() },
        this.name,
        this.platforms?.map { it.toEntity() },
        this.perspectives?.map { it.toEntity() },
        this.screenShots?.map { it.toEntity() },
        this.similarGames?.map { it.toEntity() },
        this.summary,
        this.storyLine,
        this.totalRating,
        this.videos?.map { it.toEntity() }
    )
}

internal fun ScreenshotDto.toEntity() = ScreenshotEntity(this.id, this.imageId)

internal fun GameModeDto.toEntity() = GameModeEntity(this.id, this.name)

internal fun GenreDto.toEntity() = GenreEntity(this.id, this.name)

internal fun VideoDto.toEntity() = VideoEntity(this.id!!, this.videoId!!)

internal fun SimilarGameDto.toEntity() =
    SimilarGameEntity(this.id, this.cover?.toEntity(), this.name)

internal fun PerspectiveDto.toEntity() = PerspectiveEntity(this.id, this.name)

internal fun PlatformDto.toEntity() = PlatformEntity(this.id, this.name)