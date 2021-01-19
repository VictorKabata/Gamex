package com.vickikbt.data.models.dto

import com.google.gson.annotations.SerializedName

data class GameModeDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?
)