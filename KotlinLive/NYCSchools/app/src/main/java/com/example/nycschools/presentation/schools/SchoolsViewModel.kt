package com.example.nycschools.presentation.schools

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschools.data.model.School
import com.example.nycschools.domain.usecase.GetSchoolsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolsViewModel @Inject constructor(
    private val getSchoolsUseCase: GetSchoolsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SchoolsState())
    val state: StateFlow<SchoolsState> = _state.asStateFlow()

    init {
        loadSchools()
    }

    private fun loadSchools() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            getSchoolsUseCase().collect { schools ->
                _state.update {
                    it.copy(
                        schools = schools,
                        isLoading = false,
                        error = if (schools.isEmpty()) "No schools found" else null
                    )
                }
            }
        }
    }

    fun onSchoolSelected(school: School) {
        _state.update { it.copy(selectedSchool = school) }
    }

    fun clearSelectedSchool() {
        _state.update { it.copy(selectedSchool = null) }
    }
}

data class SchoolsState(
    val schools: List<School> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedSchool: School? = null
)