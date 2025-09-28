package com.ecomartx.practise1.parctise

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow

fun main() {

    val liveData = MutableLiveData<String>()
    liveData.value="Hello World"

//    liveData.observe(this) { message ->
//        println("Received: $message")
//    }


    val stateFlow = MutableStateFlow("Initial Message")

// Watching for changes (works anywhere with coroutines)
//    viewModelScope.launch {
//        stateFlow.collect { message ->
//            println("Received: $message")
//        }
//    }

}