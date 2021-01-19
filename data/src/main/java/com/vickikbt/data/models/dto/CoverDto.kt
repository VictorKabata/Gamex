package com.vickikbt.data.models.dto

import com.google.gson.annotations.SerializedName

data class CoverDto(
    @SerializedName("id")
    val id:Int?,

    @SerializedName("image_id")
    val imageId:String?
)