package com.vickikbt.data.models.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded

//@Entity(tableName = "Companies Table")
data class CompaniesEntity(
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "company")
    @Embedded(prefix = "_company")
    val company: CompanyEntity?
)