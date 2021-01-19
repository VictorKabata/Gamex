package com.vickikbt.gamex.ui.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vickikbt.data.util.ApiException
import com.vickikbt.domain.models.Game
import com.vickikbt.domain.usecases.FetchGameDetailsUseCase
import com.vickikbt.gamex.util.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import java.net.UnknownHostException

class GameDetailViewModel @ViewModelInject constructor(private val fetchGameDetailsUseCase: FetchGameDetailsUseCase) :
    ViewModel() {

    //val idMutableLiveData = MutableLiveData<Int>()

    private val _gameDetails = MutableLiveData<Game>()
    val gameDetails: LiveData<Game> get() = _gameDetails

    var stateListener: StateListener? = null

    init {
        //fetchGameDetails()
    }

    fun fetchGameDetails(id: Int) = liveData {
        stateListener?.loading()

        Log.e("VickiKbt", "fetchGameDetails invoked")

        try {
            fetchGameDetailsUseCase.invoke(id).collect { game ->
                emit(game)
            }
            stateListener?.success()
            return@liveData
        } catch (e: ApiException) {
            stateListener?.failure("${e.message}")
            return@liveData
        } catch (e: UnknownHostException) {
            stateListener?.failure("Ensure you have an internet connection")
            return@liveData
        }
    }

}