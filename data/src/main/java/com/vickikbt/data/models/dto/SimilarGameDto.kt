package com.vickikbt.data.models.dto

import com.google.gson.annotations.SerializedName

data class SimilarGameDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("cover")
    val cover: CoverDto?,

    @SerializedName("name")
    val name: String?
)