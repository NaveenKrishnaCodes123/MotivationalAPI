package com.ecomartx.practise1.parctise

import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.zip

suspend fun main1(){
    flowOf(1, 2, 3, 4)
        .filter { it % 2 == 0 }
        .collect { println(it) }
}

suspend fun  main2(){
    flowOf(1, 2, 3)
        .map { it * 10 }
        .collect { println(it) }  // 10, 20, 30
}

suspend fun  main(){
    val flow1 = flowOf(1, 2, 3)
    val flow2 = flowOf("A", "B", "C")

    flow1.zip(flow2) { a, b -> "$a -> $b" }
        .collect { println(it) }

    val sum = flowOf(1, 2, 3).reduce { add,
                                       value -> add + value }
    println(sum)
}