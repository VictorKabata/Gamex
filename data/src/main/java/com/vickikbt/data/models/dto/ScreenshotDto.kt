package com.vickikbt.data.models.dto

import com.google.gson.annotations.SerializedName

data class ScreenshotDto(
    @SerializedName("id")
    val id:Int,

    @SerializedName("image_id")
    val imageId:String
)