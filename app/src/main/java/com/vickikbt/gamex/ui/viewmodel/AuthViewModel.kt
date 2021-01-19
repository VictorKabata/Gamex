package com.vickikbt.gamex.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.vickikbt.data.util.ApiException
import com.vickikbt.domain.usecases.FetchAccessTokenUseCase
import com.vickikbt.domain.usecases.GetAccessTokenUseCase
import com.vickikbt.gamex.util.StateListener
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class AuthViewModel @ViewModelInject constructor(
    private val fetchAccessTokenUseCase: FetchAccessTokenUseCase,
    private val getAccessTokenUseCase: GetAccessTokenUseCase
) : ViewModel(){

    var stateListener:StateListener?=null

    fun fetchAccessToken(){
        stateListener?.loading()

        viewModelScope.launch {
            try {
                fetchAccessTokenUseCase.invoke()
                stateListener?.success()
                return@launch
            }catch (e:ApiException){
                stateListener?.failure("${e.message}")
                return@launch
            }catch (e:UnknownHostException){
                stateListener?.failure("Ensure you have an active internet connection")
                return@launch
            }
        }
    }

    val getAccessToken=getAccessTokenUseCase.invoke().asLiveData()

}