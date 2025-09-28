package com.ecomartx.motivationalapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MotivationalViewModel : ViewModel() {
    private val repository = MotivationalRepository()

    private val _phrases = MutableStateFlow<List<MotivationalPhrase>>(emptyList())
    val phrases: StateFlow<List<MotivationalPhrase>> = _phrases.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadPhrases()
    }

    fun loadPhrases() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                _phrases.value = repository.getPhrases()
            } catch (e: Exception) {
                _error.value = "Failed to load phrases: ${e.message}"
                _phrases.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
}