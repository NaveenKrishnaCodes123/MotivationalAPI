package com.mindcoin.dservicevp.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mindcoin.dservicevp.repository.VehicleRepository
import com.mindcoin.dservicevp.viewModel.VehicleViewModel
import com.mindcoin.dservicevp.viewModel.VehicleViewModel.DeviceTokenViewModel

class VehicleViewModelFactory(private val repository: VehicleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VehicleViewModel.VehicleViewModelList(repository) as T
    }
}
class VehicleViewModelItemFactory(private val repository: VehicleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VehicleViewModel.VehicleViewModelListItem(repository) as T
    }
}
class VehicleViewCheckOutFactory(private val repository: VehicleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VehicleViewModel.VehicleDetailCheckOutViewModel(repository) as T
    }
}

class UpdatePasswordFactory(private val repository: VehicleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VehicleViewModel.UpDatePasswordViewModel(repository) as T
    }
}
class DeviceTokenViewModelFactory(private val repository: VehicleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeviceTokenViewModel::class.java)) {
            return DeviceTokenViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}