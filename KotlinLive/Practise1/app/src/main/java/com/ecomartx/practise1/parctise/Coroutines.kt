package com.ecomartx.practise1.parctise

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//  fun main() {
//     println("Function Started")
//    runBlocking {
//        repeat(10000)
//        {
//            launch {
//                println("Thread $it")
//            }
//        }
//
//    }
//     println("Function Completed")
//
//}
 suspend fun getUserDataFromApi(): String {
    for (i in 1..100000) {
        println(i)
    }

    //delay(10000)
    return "User data loaded"
}


fun main() {
    println("Fetching...")

    GlobalScope.launch {

            val data = getUserDataFromApi()
            println(data)
        //repeat(10000)
//        {
//            launch {
//                println("Thread")
//            }
//        }

    }
    println("Data Fetch Successfully")
}

open class Naveen() {
    fun data() {
        println("Print Naveen")
    }
}

class Naveen2: Naveen()








