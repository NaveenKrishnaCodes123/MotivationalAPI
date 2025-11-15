package com.nycschools.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nycschools.domain.model.School
import com.nycschools.domain.usecase.GetSchoolsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@OptIn(ExperimentalCoroutinesApi::class)
class SchoolListViewModel(private val getSchools: GetSchoolsUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<List<School>>(emptyList())
    val uiState: StateFlow<List<School>> = _uiState

    init {
        load()
    }

    private fun load() {
        getSchools().onEach { list ->
            _uiState.value = list
        }.launchIn(viewModelScope)
    }
}
