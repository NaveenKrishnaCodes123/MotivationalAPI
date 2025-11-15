package com.nycschools.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nycschools.domain.model.School
import com.nycschools.domain.repository.SchoolRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class SchoolDetailViewModel(private val repo: SchoolRepository,private val dispatcher: CoroutineDispatcher = Dispatchers.Main) : ViewModel() {
    private val _uiState = MutableStateFlow<School?>(null)
    val uiState: StateFlow<School?> = _uiState

    fun load(dbn: String) {
        viewModelScope.launch {
            val school = repo.getSchoolDetail(dbn)
            _uiState.value = school
        }
    }
}
