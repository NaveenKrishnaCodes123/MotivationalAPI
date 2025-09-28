package com.ecomartx.practise1.leecode

fun main(){
    val strs = arrayOf("flower", "flow", "flight")

   val sorted = strs.sorted()
    val first=sorted.first()
    val secound=sorted.last()

    var i=0
     while (i<first.length&& i < secound.length&& first[i]==secound[i] ){
         i++
     }

    //Merge two sorted arrays

    println(first.substring(0,i))

    val arr1 = intArrayOf(1, 3, 5, 7)
    val arr2 = intArrayOf(2, 4, 6, 8, 9)

    val merged = (arr1 + arr2).sorted()
    println(merged.joinToString()) // 1, 2, 3, 4, 5, 6, 7, 8, 9


}