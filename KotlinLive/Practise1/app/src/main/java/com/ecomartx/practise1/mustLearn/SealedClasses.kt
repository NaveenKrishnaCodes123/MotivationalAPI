package com.ecomartx.practise1.mustLearn

sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}

fun handleResult(result: Result) {
    when (result) {
        is Result.Success -> println("Got data: ${result.data}")
        is Result.Error -> println("Error: ${result.message}")
        Result.Loading -> println("Loading...")
    }
}
//for network call we will use
//Sealed class in Kotlin = A class that has a fixed set of subclasses.
//
//All subclasses must be in the same file.
//
//Mostly used with when to cover all cases safely.