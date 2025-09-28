package com.ecomartx.mytask


//[1,2,3,5,6,7,9,10]

fun main(){

    //missingNumbers
    val numbers =listOf(1,2,3,6,9,10)
    val range=(numbers.first()..numbers.last())
    val missingNumbers= range.filter {
          it!in numbers
    }
    println(missingNumbers)



    val hi = range.filter {
        it!in numbers
    }
    println(missingNumbers)

}