package com.vickikbt.data.models.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Auth_Table")
data class AuthEntity(

    @ColumnInfo(name = "Access Token")
    @PrimaryKey(autoGenerate = false)
    val accessToken: String,

    @ColumnInfo(name = "Expires In")
    val expiresIn: Int
)