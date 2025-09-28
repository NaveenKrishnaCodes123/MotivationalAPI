package com.ecomartx.practise1.mustLearn

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main()= runBlocking {
println("Start")
    supervisorScope {
        launch{
            delay(1000)
            println("Task 1 is done")
        }

        launch {
            delay(1500)
            throw RuntimeException("EEEEE")
        }

        launch {
            delay(2000)
            println("Naveen")
        }
    }

    coroutineScope {
        launch{
            delay(1000)
            println("Task 1 is done")
        }

        launch {
            delay(1500)
            throw RuntimeException("EEEEE")
        }

        launch {
            delay(2000)
            println("Naveen")
        }
    }
 println("Finished")

}