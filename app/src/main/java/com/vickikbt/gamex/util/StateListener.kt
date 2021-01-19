package com.vickikbt.gamex.util

interface StateListener {

    fun loading()

    fun success()

    fun failure(message: String)

}