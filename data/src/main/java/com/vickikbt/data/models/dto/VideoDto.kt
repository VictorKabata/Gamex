package com.vickikbt.data.models.dto

import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("video_id")
    val videoId: String?
)