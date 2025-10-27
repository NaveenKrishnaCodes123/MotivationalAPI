package com.ecomartx.practise1.leecode

import androidx.collection.intSetOf


//Input: nums = [1, 2, 3, 3]
//
//Output: true

//Input: nums = [1, 2, 3, 4]
//
//Output: false

//Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

var num=intArrayOf(1, 2, 3, 4,2,5,1,5)
fun main(){

    println(containsDuplicate(num))

}

fun containsDuplicate(value: IntArray){

    var repete= mutableSetOf<Int>()
    for(i in value){
        if(!repete.add(i)){
            println(i)
        }
    }

}









