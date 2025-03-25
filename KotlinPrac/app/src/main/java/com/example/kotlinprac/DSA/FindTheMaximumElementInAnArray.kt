package com.example.kotlinprac.DSA

fun main(){

    val arrayData= intArrayOf(4,9,0,3,2,3,4,5,6,7,8)

    //we can Use Both Conditions
    println("FindTheMaximumElementInAnArray :" +arrayData.max())
    println("FindTheMaximumElementInAnArray :" +arrayData.maxOrNull())
  //  FindTheMinimumElementInAnArray

    println("FindTheMinimumElementInAnArray : "+ arrayData.minOrNull())

}