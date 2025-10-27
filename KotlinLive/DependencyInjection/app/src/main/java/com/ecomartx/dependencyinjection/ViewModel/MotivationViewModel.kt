package com.ecomartx.dependencyinjection.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecomartx.dependencyinjection.Model.MotivationalPhrase
import com.ecomartx.dependencyinjection.Repository.MotivationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MotivationViewModel @Inject constructor(
    private val repository: MotivationRepository
) : ViewModel() {

    private val _quotes = MutableStateFlow<List<MotivationalPhrase>>(emptyList())
    val quotes: StateFlow<List<MotivationalPhrase>> = _quotes

    init {
        viewModelScope.launch {
            repository.getQuotes().collect { list ->
                _quotes.value = list
            }
        }
    }
}
