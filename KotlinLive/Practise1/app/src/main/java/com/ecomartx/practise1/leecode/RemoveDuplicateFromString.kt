package com.ecomartx.practise1.leecode

//Remove duplicate from string
fun main0(){
    val str = "aabbccddeeff"
   val result=str.toCharArray().distinct()
    println(result)
}
//Input =a2b3c4 and output = aabbbcccc

fun main(){
    val str = "a2b3c4"
    val result= str.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)".toRegex()).chunked(2).joinToString("")
    {
            (char, num)->
        char.repeat(num.toIntOrNull()?:1)
    }
    println(result)
}