package com.vickikbt.data.models.entity

import androidx.room.ColumnInfo

data class VideoEntity(
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "video_id")
    val videoId: String
)