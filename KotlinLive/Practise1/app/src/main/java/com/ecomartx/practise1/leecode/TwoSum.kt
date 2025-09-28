package com.ecomartx.practise1.leecode

//Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
//
//You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
//
//Return the answer with the smaller index first.

//Input:
//nums = [3,4,5,6], target = 7

//Output: [0,1]

var nums = intArrayOf(3,4,5,6)
var target = 7

fun main(){

    val valus= TwoSum()
   //println(valus.toList())

}


fun TwoSum(){

    for(i in nums.indices){
        for(j in i+1 until nums.size){
            if(nums[i]+nums[j]==target){
                println("$i  $j")
            }
        }
    }
}

