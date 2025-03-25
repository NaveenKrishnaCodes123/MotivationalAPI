package com.example.kotlinprac.DSA

fun main() {
    var n=3

    for (i in 1..10){
        println("$n * $i = "+n*i)
    }
    /*do {
        println("$n * $k = "+n*i)
        k++
    }while (
        k<=10
    )*/

    var name= arrayOf("One","Two","Three","Four","Five","Six")

    for (i in 0..name.size-1){
       println(name[i])
    }
}