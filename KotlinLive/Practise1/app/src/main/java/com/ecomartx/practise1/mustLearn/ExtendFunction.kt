package com.ecomartx.practise1.mustLearn

fun String.addExcitement(): String {
    return this + "!!" // "this" refers to the string itself
}

fun main() {
    val name = "Kotlin"

    // Now you can call your new function directly on any String!
    println(name.addExcitement()) // Output: Kotlin!!

    // You can even use it directly on a text value
    println("Hello".addExcitement()) // Output: Hello!!
}