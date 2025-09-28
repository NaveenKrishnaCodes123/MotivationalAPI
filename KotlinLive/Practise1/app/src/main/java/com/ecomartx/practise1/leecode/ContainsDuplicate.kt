package com.ecomartx.practise1.leecode


//Input: nums = [1, 2, 3, 3]
//
//Output: true

//Input: nums = [1, 2, 3, 4]
//
//Output: false

//Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

var num=intArrayOf(1, 2, 3, 4)
fun main(){

    println(containsDuplicate(num))

}
fun containsDuplicate(ints: IntArray): Boolean {
    var set= mutableSetOf<Int>()
    for(i in ints){
        if(!set.add(i)){
            return true
        }
    }

    return false
}









