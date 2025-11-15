package com.mindcoin.dservicevp.Model

import androidx.lifecycle.ViewModelProvider
import com.mindcoin.dservicevp.apis.ApiService

class VehicleCheckInViewModelFactory(
    private val api: ApiService
) : ViewModelProvider.Factory {

}