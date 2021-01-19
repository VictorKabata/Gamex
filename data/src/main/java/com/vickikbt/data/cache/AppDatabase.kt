package com.vickikbt.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vickikbt.data.cache.daos.AuthDao
import com.vickikbt.data.models.entity.AuthEntity

@Database(entities = [AuthEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun authDao(): AuthDao

}