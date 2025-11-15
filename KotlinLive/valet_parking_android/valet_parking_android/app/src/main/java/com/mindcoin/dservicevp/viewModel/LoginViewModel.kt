package com.mindcoin.dservicevp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mindcoin.dservicevp.Model.login.LoginResponse
import com.mindcoin.dservicevp.apis.ApiCallback
import com.mindcoin.dservicevp.apis.ApiRepository

class LoginViewModel: ViewModel() {

    private val apiRepository = ApiRepository()
    private val _apiResponse = MutableLiveData<LoginResponse>()
    val apiResponse: LiveData<LoginResponse> get() = _apiResponse

    fun login(username: String, password: String, osType: Int) {
        apiRepository.login(username, password, osType, object : ApiCallback {
            override fun onSuccess(response: LoginResponse) {
                _apiResponse.value = response
            }

            override fun onFailure(errorMessage: String) {
                // Handle failure here if needed
            }
        })
    }
}