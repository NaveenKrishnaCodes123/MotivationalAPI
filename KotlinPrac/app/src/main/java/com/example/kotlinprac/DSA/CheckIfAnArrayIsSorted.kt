package com.example.myapplication.DSA

fun main(){
    val array= intArrayOf(9,4,5,6,7,8,2,3,4,5,6,7,8,9)
    //val isSortedAscending = array.indices.drop(1).all { array[it] <= array[it + 1] }
    val isSortedAscending = (0 until array.size - 1).all { array[it] <= array[it + 1] }

    if(isSortedAscending){
        println("Sorted Ascending Order")
    }else{
        println("Sorted Not Ascending Order")
    }
}