package com.mindcoin.dservicevp.apis

import com.mindcoin.dservicevp.Model.login.LoginResponse

interface ApiCallback {
    fun onSuccess(response: LoginResponse)
    fun onFailure(errorMessage: String)
}