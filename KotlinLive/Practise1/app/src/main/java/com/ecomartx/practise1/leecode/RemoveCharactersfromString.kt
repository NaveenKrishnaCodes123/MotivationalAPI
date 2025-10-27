package com.ecomartx.practise1.leecode

fun main(){
    val input = "hello world"
    val remove = "lo"

   val result= input.filter {
       it !in remove
   }
    print(result)
}