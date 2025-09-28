package com.ecomartx.practise1.leecode


// Find the duplicate
val  arrayData = intArrayOf(1, 3, 4, 2,7,9,7)

fun main(){

    val data= findTheDuplicate(arrayData)
}

fun findTheDuplicate(data: IntArray){
     var duplicateValue=mutableSetOf<Int>()
     var dupli=-1
     for(i in data){
         if(!duplicateValue.add(i)){
             dupli=i
             break
          }

     }
    println(dupli)
}
