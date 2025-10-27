package com.ecomartx.practise1.leecode

fun main(){

    var nums= intArrayOf(1,2,3,4,5,6,7)
        var first =mutableSetOf<Int>()
        var secound =mutableSetOf<Int>()

        for(i in nums.size until 3){
            first.add(i)
            println("i = $i")
        }

    println(first)

}


