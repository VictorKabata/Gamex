package com.vickikbt.gamex.ui.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickikbt.data.util.ApiException
import com.vickikbt.data.util.Constants.RELEASED
import com.vickikbt.data.util.Constants.UNRELEASED
import com.vickikbt.domain.models.Game
import com.vickikbt.domain.usecases.FetchGamesUseCase
import com.vickikbt.gamex.util.StateListener
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class HomeViewModel @ViewModelInject constructor(private val fetchGamesUseCase: FetchGamesUseCase) :
    ViewModel() {

    var stateListener: StateListener? = null

    private val _unreleasedPopularGames = MutableLiveData<List<Game>>()
    val unreleasedPopularGames: LiveData<List<Game>> get() = _unreleasedPopularGames

    private val _releasedPopularGames = MutableLiveData<List<Game>>()
    val releasedPopularGames: LiveData<List<Game>> get() = _releasedPopularGames

    val someShit = "this is jus a sample message to test out how append works irl where id="

    init {
        fetchUnreleasedPopularGames()
        fetchReleasedPopularGames()
    }

    private fun fetchUnreleasedPopularGames() {
        stateListener?.loading()

        viewModelScope.launch {
            try {
                val unreleasedPopularGamesResponse = fetchGamesUseCase.invoke(UNRELEASED)
                unreleasedPopularGamesResponse.collect { games ->
                    _unreleasedPopularGames.value = games
                }
                stateListener?.success()
                return@launch
            } catch (e: ApiException) {
                stateListener?.failure("${e.message}")
                return@launch
            } catch (e: UnknownHostException) {
                stateListener?.failure("Ensure you have an internet connection")
                return@launch
            }
        }
    }

    private fun fetchReleasedPopularGames() {
        stateListener?.loading()

        viewModelScope.launch {
            try {
                val unreleasedPopularGamesResponse = fetchGamesUseCase.invoke(RELEASED)
                unreleasedPopularGamesResponse.collect { games ->
                    _releasedPopularGames.value = games
                }
                stateListener?.success()
                return@launch
            } catch (e: ApiException) {
                stateListener?.failure("${e.message}")
                return@launch
            } catch (e: UnknownHostException) {
                stateListener?.failure("Ensure you have an internet connection")
                return@launch
            }
        }
    }

}