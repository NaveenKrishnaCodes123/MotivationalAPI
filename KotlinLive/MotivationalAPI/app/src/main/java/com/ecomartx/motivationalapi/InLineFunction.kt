package com.ecomartx.motivationalapi


inline fun doSomething(operation: () -> Unit) {
    println("Before operation")
    operation()
    println("After operation")
}

fun main() {
    doSomething {
        println("Hello, from lambda!")
    }
}