package com.vickikbt.data.models.entity

import androidx.room.ColumnInfo

data class CoverEntity(
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "image_id")
    val imageId: String?
)