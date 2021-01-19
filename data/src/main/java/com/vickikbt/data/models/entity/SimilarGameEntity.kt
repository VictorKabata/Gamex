package com.vickikbt.data.models.entity

import androidx.room.ColumnInfo

data class SimilarGameEntity(
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "cover")
    val cover: CoverEntity?,

    @ColumnInfo(name = "name")
    val name: String?
)