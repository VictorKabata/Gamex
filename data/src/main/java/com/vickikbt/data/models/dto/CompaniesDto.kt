package com.vickikbt.data.models.dto

import com.google.gson.annotations.SerializedName
import com.vickikbt.domain.models.Company

data class CompaniesDto(
    @SerializedName("id")
    val id:Int?,

    @SerializedName("company")
    val company: CompanyDto?
)