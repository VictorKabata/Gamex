package com.vickikbt.data.models.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class AuthDto(

    @SerializedName("access_token")
    val accessToken:String?,

    @SerializedName("expires_in")
    val expiresIn:Int?
)