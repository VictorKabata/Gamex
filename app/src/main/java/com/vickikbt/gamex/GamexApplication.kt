package com.vickikbt.gamex

import android.app.Application
import com.rommansabbir.networkx.NetworkX
import com.rommansabbir.networkx.NetworkXObservingStrategy
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GamexApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        NetworkX.startObserving(
            this,
            NetworkXObservingStrategy.REALTIME
        ) //How often to check for internet connectivity status
    }

}