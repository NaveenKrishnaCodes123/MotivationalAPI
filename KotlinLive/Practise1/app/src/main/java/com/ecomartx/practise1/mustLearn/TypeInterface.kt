package com.ecomartx.practise1.mustLearn

fun main() {
    // You show Kotlin "Hello". Kotlin knows it's a String.
    val message ="Hello"

    // You show Kotlin 25. Kotlin knows it's an Int.
    val age = 25

    // You show Kotlin 99.95. Kotlin knows it's a Double.
    val price = 99.95

    // You show Kotlin 'true'. Kotlin knows it's a Boolean.
    val isReady = true

    // You tell Kotlin you want a list of these fruits.
    // Kotlin knows it's a List<String>.
    val fruits = listOf("Apple", "Banana", "Mango")

    // Print the types to prove it
    println("message is of type: ${message::class.simpleName}") // String
    println("age is of type: ${age::class.simpleName}") // Int
    println("fruits is of type: ${fruits::class.simpleName}") // ArrayList
    println("price is of type: ${price::class.simpleName}") // ArrayList
}