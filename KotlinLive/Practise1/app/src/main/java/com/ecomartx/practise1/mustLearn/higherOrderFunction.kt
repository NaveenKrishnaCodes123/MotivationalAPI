package com.ecomartx.practise1.mustLearn

fun doOperation(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun main1() {
    val result = doOperation(5, 3) { a, b -> a + b }  // passing a function (lambda)
    println(result)  // 8
}



fun add(a: Int,b: Int): Int{
    return a+b
}

fun calculate(x: Int,y:Int,operation: (Int, Int) -> Int): Int{
    return operation(x,y)
}

fun main(){

    val result= calculate(6,7,::add)
}



