package com.ecomartx.practise1.mustLearn

val user by lazy {
    println("User object created")
    "Naveen"
}

fun main() {
    println("Before access")
    println(user)   // User object created -> Naveen
    println(user)   // Naveen (no re-creation)
}
