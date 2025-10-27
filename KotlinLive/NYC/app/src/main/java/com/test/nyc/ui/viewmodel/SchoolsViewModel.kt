
package com.test.nyc.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.nyc.domain.model.School
import com.test.nyc.domain.usecase.GetSchoolsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class SchoolsUiState(
    val items: List<School> = emptyList(),
    val isLoading: Boolean = false,
    val page: Int = 0,
    val pageSize: Int = 20,
    val endReached: Boolean = false,
    val query: String = ""
)

@HiltViewModel
class SchoolsViewModel @Inject constructor(
    private val getSchoolsUseCase: GetSchoolsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SchoolsUiState())
    val uiState: StateFlow<SchoolsUiState> = _uiState

    init {
        loadNextPage()
    }

    fun onQueryChanged(q: String) {
        _uiState.value = _uiState.value.copy(query = q, items = emptyList(), page = 0, endReached = false)
        // reload
        loadNextPage(reset = true)
    }

    fun loadNextPage(reset: Boolean = false) {
        if (_uiState.value.isLoading || _uiState.value.endReached) return
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val page = if (reset) 0 else _uiState.value.page
            val offset = page * _uiState.value.pageSize
            try {
                val fetched = getSchoolsUseCase(_uiState.value.pageSize, offset, if (_uiState.value.query.isBlank()) null else _uiState.value.query)
                val end = fetched.size < _uiState.value.pageSize
                val items = if (reset) fetched else _uiState.value.items + fetched
                _uiState.value = _uiState.value.copy(
                    items = items,
                    isLoading = false,
                    page = page + 1,
                    endReached = end
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }
}
