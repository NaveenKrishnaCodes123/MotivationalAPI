
package com.test.nyc.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.nyc.domain.model.SatScore
import com.test.nyc.domain.usecase.GetSatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SatUiState(val isLoading: Boolean = false, val sat: SatScore? = null, val error: String? = null)

@HiltViewModel
class SchoolDetailViewModel @Inject constructor(
    private val getSatUseCase: GetSatUseCase
) : ViewModel() {

    private val _satState = MutableStateFlow(SatUiState())
    val satState: StateFlow<SatUiState> = _satState

    fun loadSat(dbn: String) {
        viewModelScope.launch {
            _satState.value = SatUiState(isLoading = true)
            try {
                val sat = getSatUseCase(dbn)
                if (sat != null) {
                    _satState.value = SatUiState(isLoading = false, sat = sat)
                } else {
                    _satState.value = SatUiState(isLoading = false, error = "No SAT data")
                }
            } catch (e: Exception) {
                _satState.value = SatUiState(isLoading = false, error = e.message ?: "Error")
            }
        }
    }
}
