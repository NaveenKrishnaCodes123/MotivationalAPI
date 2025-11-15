package com.example.interviewtest.ui.theme

fun inversionCount(arr : IntArray): Int {
    var count = 0
    for (i in arr.indices)
        for(j in i+1 until arr.size)
            if (arr[i] > arr [j]){
                count ++
            }
    return count
}

fun main() {
    val arr = intArrayOf(2, 4, 1, 3, 5)
//    val arr = intArrayOf(2,3,4,5,6)
//    val arr = intArrayOf(10,10,10,10)

    println("Inversion Count = ${inversionCount(arr)}")
}