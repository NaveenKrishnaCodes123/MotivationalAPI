package com.ecomartx.practise1.leecode

fun main(){
    fibonacciSeries(10)
}

fun fibonacciSeries(value: Int) {

    var first =0
    var second =1

    for( i in 2 until value){
        val next = first + second
         first=second
        second=next
        println(next)
    }






}
