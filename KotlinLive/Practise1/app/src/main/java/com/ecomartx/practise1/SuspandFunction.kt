package com.ecomartx.practise1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

suspend fun fetchUserData(): User {
    return withContext(Dispatchers.IO) {
        // Simulate network call
        delay(1000)
        User("John", 25)
    }
}

// Usage in another suspend function or coroutine
fun main() {
    suspend fun displayUser() {
        val user = fetchUserData() // This will suspend, not block
        println("User: ${user.name}")
    }
}