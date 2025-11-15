package com.example.nycschools.presentation.schooldetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.data.model.SatScores
import com.example.nycschools.domain.usecase.GetSatScoresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolDetailViewModel @Inject constructor(
    private val getSatScoresUseCase: GetSatScoresUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val school = savedStateHandle.get<com.example.nycschools.data.model.School>("school")
        ?: throw IllegalArgumentException("School is required")

    private val _state = MutableStateFlow(SchoolDetailState(school = school))
    val state: StateFlow<SchoolDetailState> = _state.asStateFlow()

    init {
        loadSatScores()
    }

    private fun loadSatScores() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            getSatScoresUseCase(school.dbn).collect { satScores ->
                _state.update {
                    it.copy(
                        satScores = satScores,
                        isLoading = false
                    )
                }
            }
        }
    }
}

data class SchoolDetailState(
    val school: com.example.nycschools.data.model.School,
    val satScores: SatScores? = null,
    val isLoading: Boolean = false
)