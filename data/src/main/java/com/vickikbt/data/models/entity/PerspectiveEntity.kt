package com.vickikbt.data.models.entity

import androidx.room.ColumnInfo

data class PerspectiveEntity(
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "name")
    val name: String?
)