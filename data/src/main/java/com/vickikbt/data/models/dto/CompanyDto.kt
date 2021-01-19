package com.vickikbt.data.models.dto

import com.google.gson.annotations.SerializedName

data class CompanyDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?
)